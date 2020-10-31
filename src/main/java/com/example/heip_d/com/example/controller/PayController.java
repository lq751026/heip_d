package com.example.heip_d.com.example.controller;

import com.example.heip_d.com.example.bean.Orders;
import com.example.heip_d.com.example.bean.Pay;
import com.example.heip_d.com.example.bean.User;
import com.example.heip_d.com.example.mapper.OrderMapper;
import com.example.heip_d.com.example.serivce.PaySerive;
import com.example.heip_d.com.example.serivce.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 支付
 */
@Controller
public class PayController {
   @Autowired
   private PaySerive paySerive;
   @Autowired
   private UserSerivce userSerivce;
   @Autowired
   private OrderMapper orderMapper;

   @RequestMapping("/pay")
   public String pay(HttpServletRequest request, Model model){
       User user = (User) request.getSession().getAttribute("user");
         Pay pay =paySerive.findByID(user.getId());
       User user1= userSerivce.findByIdd(pay.getHelp_id());
        model.addAttribute("user",user1);
       return "pay_user";
   }

    /**
     *  上传支付截图
     * @param file
     * @param request
     * @param response
     * @throws IOException
     */

     @RequestMapping("/pay_img")
     @ResponseBody
    public void pay_img(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
         User user = (User) request.getSession().getAttribute("user");
         // 获取文件名，带后缀
         String originalFilename = file.getOriginalFilename();

             //上的有图片
             // 获取文件的后缀格式
             String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();

             // 只有当满足图片格式时才进来，重新赋图片名，防止出现名称重复的情况
             String newFileName = UUID.randomUUID() + originalFilename;
             // 该方法返回的为当前项目的工作目录，即在哪个地方启动的java线程
             String dirPath = System.getProperty("user.dir");
             String path = File.separator + "src/main/resources/static/run/images/zf/" + File.separator + newFileName;
             File destFile = new File(dirPath + path);
             if (!destFile.getParentFile().exists()) {
                 destFile.getParentFile().mkdirs();

             }
             try {
                 file.transferTo(destFile);

                 // 将相对路径返回给前端

             } catch (IOException e) {
                 response.setContentType("text/html;charset=utf-8");
                 response.getWriter().print("上传失败!");
     }

         String imgpath= "../zf/"+File.separator + newFileName;

         paySerive.saveImg(user.getId(),imgpath);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("上传成功,等待对方确认！<a href='/'>返回首页</a>");
     }
     @RequestMapping("/pay_deng")
     public String pay_deng(Model model,HttpServletRequest request){
        model.addAttribute("pay",(Pay)request.getAttribute("pay"));
         return "pay_deng";
     }
      @RequestMapping("/pay_fk")
      @ResponseBody
      public void pay_fk(@RequestParam("number")String number, HttpServletRequest request, HttpServletResponse response) throws IOException {
          User user = (User) request.getSession().getAttribute("user");
          Pay pay = null;
          try {
              //Orders orders= orderMapper.findByNumber(number);
              pay = paySerive.findByid(user.getId());
              if(pay!=null&&pay.getPay_img()!=null&&pay.getPay_code()!=1){
                   request.setAttribute("pay",pay);
                 request.getRequestDispatcher("/pay_deng").forward(request,response);
              }
          } catch (Exception e) {
              response.setContentType("text/html;charset=utf-8");
              response.getWriter().print("等待对方付款!<a href='/'>返回首页</a>");
              return;
          }
          response.setContentType("text/html;charset=utf-8");
          response.getWriter().print("等待对方付款!<a href='/'>返回首页</a>");
    }


     @RequestMapping("/pay_qr")
     @ResponseBody
    public void pay_qr(HttpServletRequest request,HttpServletResponse response) throws IOException {
         User user = (User) request.getSession().getAttribute("user");
         Integer id=user.getId();
         if (id != null && id != 0) {
             try {
                 Pay pay = paySerive.findByid(id);
                 if (pay != null) {
                     //可以修改
                     paySerive.updateCode(id);
                      paySerive.update(id,pay.getUser_id());
                     response.setContentType("text/html;charset=utf-8");
                     response.getWriter().print("订单完成!<a href='/'>返回首页</a>");

                 }
             } catch (Exception e) {
                 response.setContentType("text/html;charset=utf-8");
                 response.getWriter().print("你没有权限访问!<a href='/'>返回首页</a>");
             }
               }else{
             response.setContentType("text/html;charset=utf-8");
             response.getWriter().print("你没有权限访问!<a href='/'>返回首页</a>");
         }
     }
}

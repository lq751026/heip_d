package com.example.heip_d.com.example.controller;

import com.example.heip_d.com.example.bean.Approve;
import com.example.heip_d.com.example.bean.User;
import com.example.heip_d.com.example.serivce.ApproveSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class ApproveController {
    @Autowired
    private ApproveSerivce approveSerivce;


    /**
     * 认证
     * @return
     */
    @RequestMapping("/account")
    public String account(HttpServletRequest request, Model model){
        User user = (User) request.getSession().getAttribute("user");
        Approve useId = null;
        try {
            useId = approveSerivce.findByUseId(user.getId());
            if(useId!=null){
                switch (useId.getCode()){
                    case 0:model.addAttribute("rz","实名认证");break;
                    case 1: model.addAttribute("rz","认证审核中"); break;
                    case 2:model.addAttribute("rz","认证成功！");break;
                }
            }else{
                model.addAttribute("rz","实名认证");
            }
        } catch (Exception e) {
            model.addAttribute("rz","实名认证");
        }


        return "accont";
    }
    @RequestMapping("/courd")
    public String courd(){
        return "courd";
    }

    @RequestMapping("/courdrz")
  public void courdrz(Approve approve, MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
        String path = File.separator + "src/main/resources/static/images/attest/" + File.separator + newFileName;
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


        String imgpath= "../attest/"+File.separator + newFileName;
        approveSerivce.saveApprove(imgpath,approve.getName(),approve.getStudent_id(),approve,user.getId());
           response.sendRedirect("account");
    }

}

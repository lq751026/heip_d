package com.example.heip_d.com.example.controller;

import com.example.heip_d.com.example.UUidUtils;
import com.example.heip_d.com.example.bean.*;
import com.example.heip_d.com.example.mapper.*;
import com.example.heip_d.com.example.serivce.*;
import com.example.heip_d.com.example.serivce.impl.OrderSerivce;
import com.example.heip_d.com.example.utils.MailUtils;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class QController {
    @Autowired
    private OrderSerivce orderSerivce;
     @Autowired
     private Qserivce qserivce;
    @Autowired
    private CarouselSerivce carouselSerivce;
    @Autowired
    private NoticeSerivce noticeSerivce;
    @Autowired
    private BountyMapper bountyMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private StatusMapper statusMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AidMapper aidMapper;
    @Autowired
    private UserSerivce userSerivce;
    @Autowired
    private PayMapper payMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private StayMapper stayMapper;


    /**
     * 首页
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String hello(Model model){
        List<Aid> aids = qserivce.findAllAid();
        List<Carousel> carousels = carouselSerivce.findAllAid();
        List<Notice> notices = noticeSerivce.findAllAid();
        model.addAttribute("aids",aids);
        model.addAttribute("carousels",carousels);
        model.addAttribute("notices",notices);
         return "index";
     }

    /**
     *  接待区
     * @param model
     * @return
     */
       @RequestMapping("/run")
         public String runfindAll(HttpServletRequest request,Model model,@RequestParam(name = "page",required =true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "3")Integer size ) throws Exception {
           List<Carousel> carousels = carouselSerivce.findAllAid();
           List<Orders> orders = orderSerivce.findAll(page,size);
           for (Orders order : orders) {
               User user = userMapper.findById(order.getUser_id());
               order.setAid(aidMapper.findById(order.getAid_id()));
               Role role = roleMapper.findById(order.getRole_id());
               Status status = statusMapper.findById(order.getStatus_id());
              order.setStatus(status);
              order.setRole(role);
               order.setUser(user);
           }
           InetAddress addr = InetAddress.getLocalHost();
           String ip=addr.getHostAddress();//获得本机IP
           PageInfo pageInfos=new PageInfo(orders);
             model.addAttribute("pageinfos",pageInfos);
           model.addAttribute("carousels",carousels);
        return "run";
       }
       @RequestMapping("/orders_xq")
       public String orders_xq(Model model,@RequestParam("number")String number){
           Orders orders=orderSerivce.findNumber(number);
           User user=userMapper.findById(orders.getUser_id());
           Address address = addressMapper.findById(user.getAdd_id());
           Bounty bounty = bountyMapper.findById(user.getB_id());
           model.addAttribute("bounty",bounty);
           model.addAttribute("address",address);
           model.addAttribute("orders",orders);
           model.addAttribute("user",user);
           return "orders_xq";
       }
           
    /**
     * 联系我们
     * @param model
     * @return
     */
      @RequestMapping("/we")
        public String we(Model model){
          List<Carousel> carousels = carouselSerivce.findAllAid();
          model.addAttribute("carousels",carousels);
           return "we";
      }

    /**
     * 注册用户
     * @param user
     * @param model
     * @param response
     * @param request
     * @throws IOException
     */
      @RequestMapping("/zc")
      @ResponseBody
      public void zc(User user, Model model, HttpServletResponse response, HttpServletRequest request) throws IOException, InterruptedException {
          UUID uuid1 = UUID.randomUUID();
           String uuid=uuid1+"";
           user.setTime(new Date());
          user.setCode(0);
          user.setAuthentication(uuid);
          userSerivce.save(user);
          //                                                            localhost改成本机ip就行了
          MailUtils.sendMail(user.getEmail(),"<a href=' http://120.26.172.176/activation?uuid="+uuid+"' >点击此连接激活你的校园网账号</a>","校园跑腿网");
           response.getWriter().println("注册成功，庆前往你的电子邮箱激活你的账号！");
         
         response.sendRedirect("/tomber");
      }

       @RequestMapping("/activation")
       public void activation(@RequestParam("uuid")String uuid,HttpServletRequest request,HttpServletResponse response) throws IOException {
           try {
             userSerivce.findByuuid(uuid);

                   /**
                    * 激活成功
                    */
                   response.sendRedirect("/");

           } catch (Exception e) {
               request.setCharacterEncoding("utf-8");
               response.setContentType("text/html;charset=utf-8");
                 response.getWriter().println("激活失败！<a href='http://120.26.172.176/'></a>");
           }
       }

    /**
     *  检查是否登录
     * @return
     */
    @RequestMapping("/myuser")
    public String myuser(Model model,HttpServletRequest request){
          model.addAttribute("user",(User)request.getSession().getAttribute("user"));
        return "member";
    }
       @RequestMapping("/tomber")
       public String tomber(HttpServletRequest request,HttpServletResponse response) throws IOException {
           if(request.getSession().getAttribute("user")!=null){
               response.sendRedirect("/myuser");
            return null;
           }
          return "tomber";
       }
        @RequestMapping("/my")
        public void my(HttpServletRequest request,HttpServletResponse response) throws IOException {
          if(request.getSession().getAttribute("user")!=null){
              response.sendRedirect("/myuser");
          }else{
              response.sendRedirect("/tomber");
            }
        }
      @RequestMapping("/tozc")
      public String zc(){
        return "zc";
      }

    /**
     * 登录
     * @param user
     * @param request
     * @param response
     * @throws IOException
     */
      @RequestMapping("/deng")
      public void deng(User user,HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
          User setUser=null;
          try {
               setUser = userSerivce.findByEmail(user);
              if(setUser!=null){
                   //登录成功
                  request.getSession().setAttribute("user",setUser);
                  request.getRequestDispatcher("/my").forward(request,response);
              }else{
                  request.getSession().setAttribute("msg","邮箱或者密码不正确！");
                  request.getRequestDispatcher("/my").forward(request,response);
              }
          } catch (Exception e) {
              request.getSession().setAttribute("msg","邮箱或者密码不正确！");
              request.getRequestDispatcher("/my").forward(request,response);
          }
      }

    /**
     * 用户更新
     * @param model
     * @param request
     * @return
     */
      @RequestMapping("/personal")
      public  String personal(Model model,HttpServletRequest request){
          User user1 = (User) request.getSession().getAttribute("user");
         User user=userSerivce.findById(user1);
         model.addAttribute("user",user);
         return "personal";
      }
      @RequestMapping("/userupdate")
      public void userupdate(User user, MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
          // 获取文件名，带后缀
          String originalFilename = file.getOriginalFilename();
          if(originalFilename!=null&&!originalFilename.equals("")){
              //上的有图片
              // 获取文件的后缀格式
              String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();

              // 只有当满足图片格式时才进来，重新赋图片名，防止出现名称重复的情况
              String newFileName = UUID.randomUUID() + originalFilename;
              // 该方法返回的为当前项目的工作目录，即在哪个地方启动的java线程
              String dirPath = System.getProperty("user.dir");
              String path = File.separator + "src/main/resources/static/run/images" + File.separator + newFileName;
              File destFile = new File(dirPath + path);
              if (!destFile.getParentFile().exists()) {
                  destFile.getParentFile().mkdirs();

              }
              try {
                  file.transferTo(destFile);

                  // 将相对路径返回给前端

              } catch (IOException e) {

              }
              String imgpath= "../images"+File.separator + newFileName;
              user.setTou_img(imgpath);
             userSerivce.updateUser(user);

          }else{
                 //没有上传头像
              userSerivce.updateText(user);
          }

          response.sendRedirect("/my");
      }

    /**
     * 退出
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
      @RequestMapping("/out")
      public void out(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
           request.getSession().removeAttribute("user");
           request.getSession().setAttribute("msg","成功退出!");
          request.getRequestDispatcher("/my").forward(request,response);
      }

    /**
     *  地址
     * @return
     */
       @RequestMapping("/add_address")
       public String addressAdd(@RequestParam("id")Integer id,Model model){
          Address address=userSerivce.findAddressById(id);
          model.addAttribute("address",address);
          return "add_address";
       }
       @RequestMapping("/address")
       public String addreSs( Model model,HttpServletRequest request){
           User user = (User) request.getSession().getAttribute("user");
           Address address = userSerivce.findAddressById(user.getAdd_id());
           if(address==null){
                 Address address1=new Address();
                 address1.setAddress("四川天一学院 xxxx");
                 address1.setName(user.getName()+user.getPhone());
                 address1.setPhone(user.getPhone());
                 addressMapper.insert(address1);
              Address address2= addressMapper.findBy(user.getName()+user.getPhone());
              userMapper.updateAddress(address2.getId(),user.getId());
              address=address2;
           }
           model.addAttribute("address",address);
           return "address";
       }
       @RequestMapping("/updateaddress")
       public void updateaddress(Address address,HttpServletResponse response) throws IOException {
            userSerivce.saveAddress(address);
            response.sendRedirect("/address");
       }

    /**
     * 订单
     * @param request
     * @param model
     * @return
     */
       @RequestMapping("/orders")
       public String orders(@RequestParam("id")Integer id, HttpServletRequest request,Model model,HttpServletResponse response){
           User user = (User) request.getSession().getAttribute("user");
           try {


           } catch (Exception e) {
               List<Orders> orders=orderSerivce.findByUserid(user.getId(),user,id);
               model.addAttribute("orders",orders);
               model.addAttribute("user",user);
           }
           List<Orders> orders=orderSerivce.findByUserid(user.getId(),user,id);
        model.addAttribute("orders",orders);
        model.addAttribute("user",user);
        return "order";
       }

    /**
     * 订单取消
     * @param id
     * @param response
     * @throws IOException
     */
       @RequestMapping("/delete")
       public void delete(@RequestParam("order_number") String id,HttpServletResponse response) throws IOException {
           orderSerivce.delete(id);
           response.sendRedirect("/orders");
       }

    /**
     * 下单

     * @return
     */
    @RequestMapping("/add_orders")
        public String addOrder(){
        return "add_order";
        }

            @RequestMapping("/add_order")
            public void addOrdesr(HttpServletRequest request,HttpServletResponse response) throws IOException {
                response.setContentType("text/html;charset=utf-8");
                User user = (User) request.getSession().getAttribute("user");
                if(userMapper.findById(user.getId()).getAdd_id()==null||userMapper.findById(user.getId()).equals("null")){
                    response.getWriter().println("<a href='/address'>请先设置我的地址</a>");
                }else{
                    response.sendRedirect("/add_orders");
                }
            }

        @RequestMapping("/addOrders")
        public void addOders(AddOrder addOrder,HttpServletRequest request,HttpServletResponse response) throws IOException, ParseException {
            response.setContentType("text/html;charset=utf-8");
           User user = (User) request.getSession().getAttribute("user");


            if(user!=null){
                String uid = UUidUtils.getUUid();
                if(addOrder.getDate1()==null||addOrder.getDate1().equals("")){
                    addOrder.setDate(new Date());
                }else{
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    addOrder.setDate(sdf.parse(addOrder.getDate1()+" "+addOrder.getTime()));
                }
                    addOrder.setUid(uid);
                addOrder.setGb_id(5);
                   addOrder.setUser_id(user.getId());

                    orderSerivce.addOrder(addOrder,response);
                    response.getWriter().println("下单成功等待处理!<a href='/orders?id=0'>返回我的发布中心</a>");


            }else{
                response.getWriter().println("请先登录!<a href='/my'>返回登录</a>");
            }

        }
    /**
     *  我的抢单
     * @return
     */
        @RequestMapping("/my_order")
      public String my_orders(@RequestParam("id")Integer id, HttpServletRequest request,Model model){
            if(id==null&&id.equals("")){
                id=0;
            }
            User user = (User) request.getSession().getAttribute("user");
            List<Orders> orders =orderSerivce.findByiD(user.getId(),id);
            model.addAttribute("orders",orders);
           return "my_order";
        }


        @RequestMapping("/my_order_or")
        public void my_order_or(@RequestParam("number")String number,HttpServletResponse response) throws IOException {
              orderSerivce.updateOrder(number);
              response.sendRedirect("my_order?id=0");
        }

    /**
     * 抢单
     */
        @RequestMapping("/grab_order")
        @ResponseBody
        public void grab_order(HttpServletRequest request,HttpServletResponse response,@RequestParam("numbe")String numbe) throws IOException {
            response.setContentType("text/html;charset=utf-8");
            User user = (User) request.getSession().getAttribute("user");
            Orders orders = orderSerivce.findNumber(numbe);
             if(user!=null){

                 if(orders.getTaker_id()==0){
                     orderSerivce.grabOrder(numbe,user.getId(),user.getId());
                     response.getWriter().print("抢单成功,求你在我的抢单中心查看");
                 }else{
                     response.getWriter().print("抢单失败成功!");
                 }

             }else{
                 response.getWriter().print("请先登录!");
             }

        }

          @RequestMapping("/stay")
        public void stay(Stay stay,HttpServletResponse response,HttpServletRequest request) throws IOException, ServletException {
              try {
                  stay.setTime(new Date());
                  stayMapper.save(stay);
                  request.setAttribute("liu","留言成功");
              } catch (Exception e) {
               request.setAttribute("liu","留言失败");
              }
              request.getRequestDispatcher("/we").forward(request,response);
          }
}

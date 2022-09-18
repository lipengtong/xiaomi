package com.offcn.servlet;

import com.offcn.entity.User;
import com.offcn.service.UserService;
import com.offcn.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "userServlet",urlPatterns = "/userServlet")
public class UserServlet extends BaseServlet {
    /**
     * 验证验证码是否一致
     *
     * @param request
     * @param response
     */
    public void checkCode(HttpServletRequest request, HttpServletResponse
            response) throws IOException {
//获取到写的对象
        PrintWriter pw = response.getWriter();
//获取前端传递的参数
        String code = request.getParameter("code");
//获取session中code
        String sessionCode = (String) request.getSession().getAttribute("code");//进行对比
        if (code.equalsIgnoreCase(sessionCode)) {
            pw.print(true);
        } else {
            pw.print(false);
        }
//关闭资源
        pw.close();
    }

    //实例化UserService对象
    private UserService userService = new UserServiceImpl();

    public void checkLogin(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
//获取前端传递的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//调用service层
        User u = userService.selectByUsernameAndPassword(username, password);
        if (u == null) {
            request.setAttribute("msg", "用户名与密码不正确");
//转发到登录界面
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
//将用户存入到session中
            request.getSession().setAttribute("user", u);
//重定向到首页
            //response.sendRedirect("index.jsp");
            IndexServlet in =new IndexServlet();
            in.showInfo(request,response);
        }
//存值进行页面的跳转


    }

    /***
     * 注册
     * @param request
     * @param response
     */
    public  void register(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        //获取前端传递的参数

     /*   private String name;
        private int sex;
        private String phone_number;
        private String area;
        private int manager;
        private String username;
        private String password;
      */
     String  name=request.getParameter("name");
     String  sex=request.getParameter("sex");
     String  phone_number=request.getParameter("phone_number");
     String  area=request.getParameter("area");
     String  manager=request.getParameter("manager");
     String  username=request.getParameter("username");
     String  password=request.getParameter("password");
     //创建一个User对象
        User u =new User();
        u.setName(name);
        u.setSex(Integer.parseInt(sex));
        u.setPhone_number(phone_number);
        u.setArea(area);
        u.setManager(0);
        u.setUsername(username);
        u.setPassword(password);
        //调用service层
       int num= userService.addUser(u);
       if (num>0){
           //重定向到登录界面
           response.sendRedirect("login.jsp");
       }else{
           request.setAttribute("msg","注册失败");
           //转发注册的界面
           request.getRequestDispatcher("register.jsp").forward(request,response);
       }


    }
}
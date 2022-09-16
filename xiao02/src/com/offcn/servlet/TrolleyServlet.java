package com.offcn.servlet;


import com.offcn.entity.Trolley;
import com.offcn.entity.User;
import com.offcn.service.TrolleyService;
import com.offcn.service.impl.TrolleyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "trolleyServlet",urlPatterns = "/trolleyServlet")
public class TrolleyServlet extends BaseServlet{
    private TrolleyService trolleyService = new TrolleyServiceImpl();
    public void addTrolley(HttpServletRequest request, HttpServletResponse
            response) throws IOException {
        PrintWriter pw = response.getWriter();
//获取前端传递的参数
        String pid = request.getParameter("pid");
        String count = request.getParameter("count");
        User u = (User) request.getSession().getAttribute("user");
        int uid = u.getId();
//构建一个购物车的对象
        Trolley trolley = new Trolley();
        trolley.setUid(uid);
        trolley.setPid(Integer.parseInt(pid));
        trolley.setNumber(Integer.parseInt(count));
        int num = trolleyService.addTrolley(trolley);
        if (num > 0) {
            pw.print(true);
        } else {
            pw.print(false);
        }
//关闭资源
        pw.close();
    }
    public void showInfo(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        User u = (User) request.getSession().getAttribute("user");
        int uid = u.getId();
        List<Trolley> trolleyList = trolleyService.selectByUid(uid);
//将集合存入到作用域中
        request.setAttribute("trolleyList",trolleyList);
//进行页面转发
        request.getRequestDispatcher("trolley.jsp").forward(request,response);
    }
    public void deleteAll(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter pw = response.getWriter();
        User u = (User) request.getSession().getAttribute("user");
        int uid = u.getId();
//获取前端传递的tid
        String tid = request.getParameter("tid");
        int num = trolleyService.deleteByTid(Integer.parseInt(tid),uid);
        if (num >0){
            pw.print(true);
        }else {
            pw.print(false);
        }
    }
}
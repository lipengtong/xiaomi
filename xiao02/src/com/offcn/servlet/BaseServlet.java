package com.offcn.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取方法的名称
        req.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String methodName = req.getParameter("mark");
        //进行非空验证
        if (methodName == null || methodName.equals("")) {
            //抛出异常
            throw new RuntimeException("方法不存在");
        }

        try {
            //获取Class对象
            Class cla = this.getClass();
            //获取调用方法的对象
            Method method = cla.getMethod(methodName, HttpServletRequest.class,
                    HttpServletResponse.class);
            //调用方法
            System.out.println("=====>"+methodName);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }




}

package com.offcn.servlet;

import com.offcn.utils.VerifyCodeUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "verifyCodeServlet",urlPatterns = "/verifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//表示禁止一切缓存 包括浏览器 包括jsp
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
//时时更新 也就是 可以点击就换图片
        resp.setDateHeader("Expires", 0);
//表示响应的格式是图片
        resp.setContentType("image/jpeg");
//生成验证码
        String code = VerifyCodeUtils.generateVerifyCode(4);
//将验证码存入到session中
        req.getSession().setAttribute("code",code);
//写入到前端
//设置图片宽度
        int width=200;
        int height= 80;
        VerifyCodeUtils.outputImage(width,height,resp.getOutputStream(),code);
    }
}
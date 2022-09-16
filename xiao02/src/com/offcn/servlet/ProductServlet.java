package com.offcn.servlet;

import com.offcn.entity.Product;
import com.offcn.service.ProductService;
import com.offcn.service.impl.ProductServiceImpl;
import com.offcn.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "productServlet",urlPatterns = "/productServlet")
public class ProductServlet extends BaseServlet {
    private ProductService productService = new ProductServiceImpl();
    public void showInfoProductById(HttpServletRequest request,
                                    HttpServletResponse response) throws ServletException, IOException {
//获取前端传递的参数pid
        String pid = request.getParameter("pid");
//调用service层
        Product product = productService.selectBypid(Integer.parseInt(pid));
//将对象存入到作用率中
        request.setAttribute("product", product);
//进行转发
        request.getRequestDispatcher("product_detail.jsp").forward(request,
                response);
    }
}
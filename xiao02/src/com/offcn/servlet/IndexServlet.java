
package com.offcn.servlet;
        import com.offcn.entity.Category;
        import com.offcn.entity.Product;
        import com.offcn.entity.User;
        import com.offcn.service.CategoryService;
        import com.offcn.service.ProductService;
        import com.offcn.service.impl.CategoryServiceImpl;
        import com.offcn.service.impl.ProductServiceImpl;
        import com.offcn.service.TrolleyService;
        import com.offcn.service.impl.TrolleyServiceImpl;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.util.List;
@WebServlet(name = "indexServlet",urlPatterns = "/indexServlet")
public class IndexServlet extends BaseServlet {
    private CategoryService categoryService = new CategoryServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    private TrolleyService trolleyService = new TrolleyServiceImpl();
    public void showInfo(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
        List<Category> categoryList = categoryService.selectAll();
//存入到作用域中
        request.setAttribute("categoryList",categoryList);
//查询小米明星单品
        List<Product> productStateList = productService.selectByState(4);

      // productStateList.forEach(System.out::println);
//将输入存入到做作用域中
        request.setAttribute("productStateList",productStateList);
        User u =(User) request.getSession().getAttribute("user");
        //获取uid
        int  uid= u.getId();
        Integer count =trolleyService.selectTrolleyCount(uid);
        request.setAttribute("count",count);
        List<Product> productList = productService.selectByCname("家电");
        request.setAttribute("productList",productList);
//转发
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }}
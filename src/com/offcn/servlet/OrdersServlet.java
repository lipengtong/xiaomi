
package com.offcn.servlet;
        import com.offcn.entity.Orders;
        import com.offcn.entity.User;
        import com.offcn.service.OrdersService;
        import com.offcn.service.impl.OrdersServiceImpl;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.io.PrintWriter;
        import java.util.List;

@WebServlet(name = "ordersServlet",urlPatterns = "/ordersServlet")
public class OrdersServlet extends BaseServlet {
    private OrdersService ordersService = new OrdersServiceImpl();
    public void addOrders(HttpServletRequest request, HttpServletResponse
            response) throws IOException {
        PrintWriter pw = response.getWriter();
        String ids = request.getParameter("ids");
        Orders or = new Orders();
        or.setState(0);
//获取到当前系统时间的毫秒值
        long time = System.currentTimeMillis();
        or.setOrders_number(time+"");
        int num = ordersService.addOrders(or,ids);
        if (num >0){
            pw.print(true);
        }else{
            pw.print(false);
        }
    }

    public void payMoney(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//获取前端传递的参数
        String ids = request.getParameter("ids");
        double money = ordersService.payMoney(ids);
//存入到作用域中
        request.setAttribute("money", money);
//进行页面转发
        request.getRequestDispatcher("pay/index.jsp").forward(request,
                response);
    }
    public void showInfoOrders(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        User u = (User) request.getSession().getAttribute("user");
        int uid = u.getId();
        List<Orders> ordersList= ordersService.selectByUid(uid);
        request.setAttribute("ordersList",ordersList);
        request.getRequestDispatcher("orders_history.jsp").forward(request,response);
    }

}

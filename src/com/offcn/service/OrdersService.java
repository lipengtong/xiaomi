
package com.offcn.service;
        import com.offcn.entity.Orders;

        import java.util.List;

public interface OrdersService {
    int addOrders(Orders orders,String ids);
    double payMoney(String ids);
    List<Orders> selectByUid(int uid);
}

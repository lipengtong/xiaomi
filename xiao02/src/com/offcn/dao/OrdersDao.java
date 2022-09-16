



package com.offcn.dao;
        import com.offcn.entity.Orders;
        import com.offcn.entity.Trolley;

        import java.util.List;

public interface OrdersDao {
    int addOrders(Orders orders);
    List<Orders> selectByUid (int uid);
}

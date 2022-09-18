
package com.offcn.dao.impl;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.dao.OrdersDao;
import com.offcn.entity.Orders;
import com.offcn.entity.Trolley;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class OrdersDaoImpl implements OrdersDao {
    //获取数据源
    DataSource ds = new ComboPooledDataSource();
    //获取QueryRunner
    QueryRunner qr = new QueryRunner(ds);
    @Override
    public int addOrders(Orders orders) {
        int num = 0;
        try {
            String sql
                    ="insert into orders" +
                    "(orders_number,uid,sum_price,state,count_number)values(?,?,?,?,?)";
            Object []
                    objects={orders.getOrders_number(),
                    orders.getUid(),orders.getSum_price(),
                    orders.getState(),orders.getCount_number()};
            num = qr.update(sql,objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public List<Orders> selectByUid(int uid) {
        List<Orders> ordersList = null;
        try {
            String sql ="select * from orders where uid=?";
            ordersList = qr.query(sql,new BeanListHandler<Orders>
                    (Orders.class),uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordersList;

    }
}
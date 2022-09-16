package com.offcn.service.impl;
        import com.offcn.dao.OrdersDao;
        import com.offcn.dao.ProductDao;
        import com.offcn.dao.TrolleyDao;
        import com.offcn.dao.impl.OrdersDaoImpl;
        import com.offcn.dao.impl.ProductDaoImpl;
        import com.offcn.dao.impl.TrolleyDaoImpl;
        import com.offcn.entity.Orders;
        import com.offcn.entity.Product;
        import com.offcn.entity.Trolley;
        import com.offcn.service.OrdersService;

        import java.util.List;

public class OrdersServiceImpl implements OrdersService {
    private OrdersDao ordersDao = new OrdersDaoImpl();
    private ProductDao productDao = new ProductDaoImpl();
    private TrolleyDao trolleyDao = new TrolleyDaoImpl();
    @Override
    public int addOrders(Orders orders, String ids) {
        try {
            String [] arrays = ids.split(",");
            //定义一个总价格的变量
            double sum =0;
            int uid=-1;
// 遍历数组
            for (String s: arrays){
                Trolley trolley = trolleyDao.selectByTid(Integer.parseInt(s));
//获取pid
                int pid = trolley.getPid();
                uid= trolley.getUid();
//获取商品对象
                Product product = productDao.selectBypid(pid);
                sum+=product.getPrice();
                trolleyDao.updateOrderNumber(uid,pid,orders.getOrders_number());
            }
//设置总价格
            orders.setSum_price(sum);
            orders.setUid(uid);
//设置总数量
            orders.setCount_number(arrays.length);
            ordersDao.addOrders(orders);
            return 1;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public double payMoney(String ids) {
        String [] arrays = ids.split(",");
//定义一个总价格的变量
        double sum =0;
// 遍历数组
        for (String s: arrays){
            Trolley trolley = trolleyDao.selectByTid(Integer.parseInt(s));
//获取pid
            int pid = trolley.getPid();
//获取商品对象
            Product product = productDao.selectBypid(pid);
            sum+=product.getPrice();
        }
        return sum;

    }

    @Override
    public List<Orders> selectByUid(int uid) {
        List<Orders> ordersList = ordersDao.selectByUid(uid);
        for (Orders o : ordersList) {
            String orders_number = o.getOrders_number();
//根据订单号来进行查询
            List<Trolley> trolleyList= trolleyDao.selectTrolley(orders_number);
            o.setTrolleyList(trolleyList);
//遍历购物车集合
            for (Trolley tro : trolleyList) {
//获取商品的编号
                int pid = tro.getPid();
//根据商品的编号 查询出商品的对象
                Product pro = productDao.selectBypid(pid);
                tro.setProduct(pro);
            }
        }
        return ordersList;

    }
}

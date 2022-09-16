package com.offcn.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
        import com.offcn.dao.ProductDao;
        import com.offcn.entity.Product;
        import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
        import javax.sql.DataSource;
        import java.sql.SQLException;
        import java.util.List;
public class ProductDaoImpl implements ProductDao {
    private DataSource ds = new ComboPooledDataSource();
    private QueryRunner qr = new QueryRunner(ds);

    @Override
    public List<Product> selectByState(int state) {
        List<Product> productList = null;
        try {
            String sql ="select * from product where state=?";
            productList = qr.query(sql,new BeanListHandler<Product>
                    (Product.class),state);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return productList;
    }

    @Override
    public List<Product> selectByCname(String cname) {
        List<Product> productList = null;
        try {
            String sql ="SELECT p.*,c.name AS cname FROM category c " +
                    "INNER JOIN product p ON c.cid=p.cid WHERE p.cid=4 ";
            productList = qr.query(sql,new BeanListHandler<Product>
                            (Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
    @Override
    public Product selectBypid(int pid) {
        Product product = null;
        try {
            String sql ="select * from product where pid=?";
            product = qr.query(sql,new BeanHandler<Product>(Product.class),pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

}
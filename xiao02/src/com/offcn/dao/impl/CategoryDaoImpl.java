package com.offcn.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.dao.CategoryDao;
import com.offcn.entity.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private  DataSource  ds =new ComboPooledDataSource();
    private  QueryRunner qr =new QueryRunner(ds);
    @Override
    public List<Category> selectAll() {
        List<Category> categoryList= null;
        try {
            String sql ="select * from category";
            categoryList = qr.query(sql,new BeanListHandler<Category>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }


    public static void main(String[] args) {
        CategoryDao c = new CategoryDaoImpl();

        List<Category> categories = c.selectAll();
        System.out.println(categories);
    }
}

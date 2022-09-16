package com.offcn.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.dao.UserDao;
import com.offcn.entity.User;
import com.sun.org.apache.xpath.internal.objects.XObject;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Date;

public class UserDaoImpl  implements UserDao {


    //获取数据源
    private DataSource ds = new ComboPooledDataSource();
    //获取得到操作数据库的核心对象
    private QueryRunner qr = new QueryRunner(ds);

    @Override
    public User selectByUsernameAndPassword(String username, String password) {
        User user = null;
        try {
            String sql = "select * from  user where username=? and password=?";
            Object[] objects = {username, password};
            user = qr.query(sql, new BeanHandler<User>(User.class), objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int addUser(User user) {
        int num = 0;
        try {
            String sql = "insert into " +
                    "user(name,sex,phone_number,area,manager,username,password)" +
                    "values(?,?,?,?,?,?,?)";
            Object[] objects =
                    {user.getName(), user.getSex(), user.getPhone_number(), user.getArea()
                            , user.getManager(), user.getUsername(), user.getPassword()};
            num = qr.update(sql, objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return num;
    }
}


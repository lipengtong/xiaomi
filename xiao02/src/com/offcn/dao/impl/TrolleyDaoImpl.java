package com.offcn.dao.impl;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.dao.TrolleyDao;
import com.offcn.entity.Trolley;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class TrolleyDaoImpl implements TrolleyDao {
    private DataSource ds =new ComboPooledDataSource();
    private QueryRunner qr = new QueryRunner(ds);
    @Override
    public Trolley selectByUidAndPid(int uid, int pid) {
        Trolley trolley = null;
        try {
            String sql="select * from trolley where uid =? and pid =?";
            Object[] objects={uid,pid};
            trolley = qr.query(sql,new BeanHandler<Trolley>
                    (Trolley.class),objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trolley;

    }

    @Override
    public int updateTrolley(Trolley trolley) {
        int num = 0;
        try {
            String sql ="update trolley set number =? where uid =? and pid=?";
            Object[] objects= {trolley.getNumber(),trolley.getUid(),trolley.getPid()};
            num = qr.update(sql,objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public int addTrolley(Trolley trolley) {
        int num = 0;
        try {
            String sql ="insert into trolley(uid,pid,number)values(?,?,?)";
            Object[] objects= {trolley.getUid(),trolley.getPid(),trolley.getNumber()};
            num = qr.update(sql,objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public int selectTrolleyCount(int uid) {
        Long count = null;
        try {
            String sql ="select count(1) from trolley where uid =?";
            count = (Long) qr.query(sql,new ScalarHandler(),uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count ==null ? 0 : Integer.parseInt(count+"");

    }

    @Override
    public List<Trolley> selectByUid(int uid) {
        List<Trolley> trolleyList = null;
        try {
            String sql ="select * from trolley where uid =?";
            trolleyList = qr.query(sql,new BeanListHandler<Trolley>
                    (Trolley.class),uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trolleyList;
    }

    @Override
    public int deleteByTid(int tid, int uid) {
        try {
            String sql ="delete from trolley";
            if (tid ==-1){
            //删除所有
                sql += " where uid = ?";
                qr.update(sql,uid);
            } else {
            //单个删除
                sql += " where tid = ?";
                qr.update(sql,tid);
            }
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int updateOrderNumber(int uid, int pid, String orders_number) {
        int num=0;
        try {
            String sql ="update trolley set orders_number=? where uid =? and pid=?";
            Object[] objects={orders_number,uid,pid};
            num = qr.update(sql,objects);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public Trolley selectByTid(int tid) {
        Trolley tro =null;
        try {
            String sql ="select * from trolley where tid=?";
            tro = qr.query(sql,new BeanHandler<Trolley>(Trolley.class),tid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return tro;
}

    @Override
    public List<Trolley> selectTrolley(String orders_number) {
        List<Trolley> trolleyList = null;
        try {
            String sql ="select * from trolley where orders_number=?";
            trolleyList = qr.query(sql,new BeanListHandler<Trolley>
                            (Trolley.class)
                    ,orders_number);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trolleyList;
    }
}


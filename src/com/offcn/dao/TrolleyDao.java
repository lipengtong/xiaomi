package com.offcn.dao;

import com.offcn.entity.Trolley;

import java.util.List;

public interface TrolleyDao {
    //根据pid与uid来进行查询
    Trolley selectByUidAndPid(int uid,int pid);
    int updateTrolley(Trolley trolley);
    int addTrolley(Trolley trolley);
    int selectTrolleyCount(int uid);
    List<Trolley> selectByUid(int uid);
    //根据tid来进行删除
    int deleteByTid(int tid,int uid);
    //根据uid与pid修改订单号
    int updateOrderNumber(int uid,int pid,String orders_number);
    //根据tid来进行查询
    Trolley selectByTid(int tid);
    //根据订单编号来进行查询
    List<Trolley> selectTrolley(String orders_number);
}
package com.offcn.service.impl;


import com.offcn.dao.ProductDao;
import com.offcn.dao.impl.ProductDaoImpl;
import com.offcn.dao.TrolleyDao;
import com.offcn.dao.impl.TrolleyDaoImpl;
import com.offcn.entity.Product;
import com.offcn.entity.Trolley;
import com.offcn.service.TrolleyService;

import java.util.List;

public class TrolleyServiceImpl implements TrolleyService {
    private TrolleyDao trolleyDao = new TrolleyDaoImpl();
    private  ProductDao  productDao   = new ProductDaoImpl();
    @Override
    public int addTrolley(Trolley trolley) {
        try {
            int uid = trolley.getUid();
            int pid = trolley.getPid();
            Trolley tro = trolleyDao.selectByUidAndPid(uid,pid);
//判断对象是否为空
            if (tro ==null){
//增加
                trolleyDao.addTrolley(trolley);
            }else {
//修改 其数量
                tro.setNumber(tro.getNumber()+trolley.getNumber());
//修改的方法
                trolleyDao.updateTrolley(trolley);
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;

    }

    @Override
    public int selectTrolleyCount(int uid) {
        return trolleyDao.selectTrolleyCount(uid);
    }

    @Override
    public List<Trolley> selectByUid(int uid) {
        List<Trolley> trolleyList = trolleyDao.selectByUid(uid);
//对集合遍历
        for (Trolley t: trolleyList){
           int pid =t.getPid();
           Product product = productDao.selectBypid(pid);
           t.setProduct(product);
        }
        return trolleyList;
    }

    @Override
    public int deleteByTid(int tid, int uid) {

        return trolleyDao.deleteByTid(tid,uid);
    }
}

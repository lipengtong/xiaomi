package com.offcn.service.impl;

import com.offcn.dao.ProductDao;
import com.offcn.dao.impl.ProductDaoImpl;
import com.offcn.entity.Product;
import com.offcn.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoImpl();
    @Override
    public List<Product> selectByState(int state) {
        return productDao.selectByState(state);
    }

    @Override
    public List<Product> selectByState(String cname) {
        return productDao.selectByCname(cname);
    }

    @Override
    public Product selectBypid(int pid) {
        return productDao.selectBypid(pid);
    }

    @Override
    public List<Product> selectByCname(String cname) {

        return productDao.selectByCname(cname);
    }
}
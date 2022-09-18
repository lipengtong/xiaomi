
package com.offcn.dao;
        import com.offcn.entity.Product;
        import java.util.List;
public interface ProductDao {
    //根据状态进行查询
    List<Product> selectByState(int state);
    List<Product> selectByCname(String cname);
    Product selectBypid(int pid);
}
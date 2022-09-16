
package com.offcn.service;
        import com.offcn.entity.Product;
        import java.util.List;
public interface ProductService {
    List<Product> selectByState(int state);
    List<Product> selectByState(String cname);
    Product selectBypid(int pid);

    List<Product>selectByCname(String 家电);
}

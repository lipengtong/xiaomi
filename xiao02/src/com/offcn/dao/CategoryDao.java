
package com.offcn.dao;
        import com.offcn.entity.Category;
        import java.util.List;
public interface CategoryDao {
    //查询所有
    List<Category> selectAll();
}
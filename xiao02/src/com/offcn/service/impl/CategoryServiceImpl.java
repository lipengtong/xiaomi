
package com.offcn.service.impl;
import com.offcn.dao.CategoryDao;
import com.offcn.dao.impl.CategoryDaoImpl;
import com.offcn.entity.Category;
import com.offcn.service.CategoryService;
import java.util.List;
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public List<Category> selectAll() {
        return categoryDao.selectAll();
    }
}
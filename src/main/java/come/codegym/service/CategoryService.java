package come.codegym.service;

import come.codegym.dao.CategoryDAO;
import come.codegym.dao.ICategoryDAO;
import come.codegym.model.Category;

import java.util.List;

public class CategoryService implements ICategoryService {

    CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    public List<Category> findAll() {
       return categoryDAO.findAll();
    }
}

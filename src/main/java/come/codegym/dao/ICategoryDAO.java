package come.codegym.dao;

import come.codegym.model.Category;

import java.util.List;

public interface ICategoryDAO {
    List<Category> findAll();
}

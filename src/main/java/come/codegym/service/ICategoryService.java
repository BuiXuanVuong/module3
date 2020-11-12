package come.codegym.service;

import come.codegym.model.Category;
import come.codegym.model.Product;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}

package come.codegym.service;

import come.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findOne(Long id);
    void save(Product product);
    boolean update(Product product);
    boolean delete(Long id);
    List<Product> findByName(String name);
}

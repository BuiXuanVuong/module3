package come.codegym.dao;

import come.codegym.model.Product;

import java.util.List;

public interface IProductDAO {
    public void save(Product product);

    public Product findOne(Long id);

    public List<Product> findAll();

    public boolean delete(Long id);

    public boolean update(Product product);

    public List<Product> findByName(String name);

}

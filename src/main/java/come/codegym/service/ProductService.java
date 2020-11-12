package come.codegym.service;

import come.codegym.dao.ProductDAO;
import come.codegym.model.Product;

import java.util.List;

public class ProductService implements IProductService {

    ProductDAO productDAO = new ProductDAO();

    @Override
    public List<Product> findAll() {
       return productDAO.findAll();
    }

    @Override
    public Product findOne(Long id) {
       return productDAO.findOne(id);
    }

    @Override
    public void save(Product product) {
        productDAO.save(product);
    }

    @Override
    public boolean update(Product product) {
       return productDAO.update(product);
    }

    @Override
    public boolean delete(Long id) {
        return productDAO.delete(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productDAO.findByName(name);
    }
}

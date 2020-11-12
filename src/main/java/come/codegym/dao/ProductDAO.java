package come.codegym.dao;

import come.codegym.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO{
    private String url = "jdbc:mysql://localhost:3306/exam?useSSL=false";
    private String user = "root";
    private String password = "123456";

    private static final String INSERT = "INSERT INTO product" + "  (productname, categoryid, price, quantity, color) VALUES " +
            " (?, ?, ?, ?, ?);";

    private static final String FIND_ONE= "select * from product where id =?";
    private static final String FIND_ALL = "select * from product";
    private static final String DELETE = "delete from product where id = ?;";
    private static final String UPDATE = "update product set productname = ?,categoryid = ?, price = ?, quantity = ?, color = ? where id = ?;";
    private static final String FINDBYNAME = "select * from product where productname like ?";
    public ProductDAO() {

    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    @Override
    public void save(Product product) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
                preparedStatement.setString(1, product.getProductName());
                preparedStatement.setLong(2,product.getCategoryId());
                preparedStatement.setLong(3,product.getPrice());
                preparedStatement.setLong(4,product.getQuantity());
                preparedStatement.setString(5, product.getColor());
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findOne(Long id) {
        Product product = null;
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_ONE)) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                String productName = rs.getString("productname");
                Long categoryId = rs.getLong("categoryid");
                Long price = rs.getLong("price");
                Long quantity = rs.getLong("quantity");
                String color = rs.getString("color");
                product = new Product(id, productName, categoryId, price, quantity, color);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String productName = rs.getString("productname");
                Long categoryId = rs.getLong("categoryid");
                Long price = rs.getLong("price");
                Long quantity = rs.getLong("quantity");
                String color = rs.getString("color");
                products.add(new Product(id, productName, categoryId, price, quantity, color));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FINDBYNAME)) {
            preparedStatement.setString(1,name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String productName = rs.getString("productname");
                Long categoryId = rs.getLong("categoryid");
                Long price = rs.getLong("price");
                Long quantity = rs.getLong("quantity");
                String color = rs.getString("color");
                products.add(new Product(id, productName, categoryId, price, quantity, color));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean delete(Long id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setLong(1,id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Product product) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)){
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setLong(2,product.getCategoryId());
            preparedStatement.setLong(3, product.getPrice());
            preparedStatement.setLong(4, product.getQuantity());
            preparedStatement.setString(5, product.getColor());
            preparedStatement.setLong(6,product.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }



}


//private static final String UPDATE = "update product set productname = ?,categoryid = ?, price = ?, quantity = ?, color = ? where id = ?;";
package come.codegym.dao;

import come.codegym.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO{

    private String url = "jdbc:mysql://localhost:3306/exam?useSSL=false";
    private String user = "root";
    private String password = "123456";

    public CategoryDAO() {

    }

    private static final String FIND_ALL = "select * from category";

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
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String code = rs.getString("code");
                Category category = new Category(id, code);
                categories.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categories;
    }
}

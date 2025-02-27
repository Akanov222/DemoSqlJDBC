package edu.demosql.first.repository.dao;

import edu.demosql.first.repository.config.Config;
import edu.demosql.first.repository.domain.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static edu.demosql.first.repository.config.Config.*;

public class ProductDaoImpl {

    public static final String SELECT_PRODUCTS =
            "SELECT maker, model, type FROM product";

    public static final String SAVE_PRODUCT =
            "INSERT INTO product (" +
                    "maker," +
                    "model," +
                    "type)" +
                    "VALUES (?, ?, ?)";

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                Config.getProperty(DB_URL),
                Config.getProperty(DB_LOGIN),
                Config.getProperty(DB_PASSWORD));
        return connection;
    }

    public List<Product> getAllProduct() {
        List<Product> result = new ArrayList<>();
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCTS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product oneProduct = fillProducts(resultSet);
                result.add(oneProduct);
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private Product fillProducts(ResultSet rs) throws SQLException {
        Product oneProduct = new Product();
        oneProduct.setMaker(rs.getString("maker"));
        oneProduct.setModel(rs.getInt("model"));
        oneProduct.setType(rs.getString("type"));
        return oneProduct;
    }

    public void saveProduct(Product product) {
        try (Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SAVE_PRODUCT)) {
            connection.setAutoCommit(false);
            try {
                statement.setString(1, product.getMaker());
                statement.setInt(2, product.getModel());
                statement.setString(3, product.getType());
                statement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw e;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

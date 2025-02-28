package edu.demosql.first.repository.dao;

import edu.demosql.first.repository.config.Config;
import edu.demosql.first.repository.domain.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static edu.demosql.first.repository.config.Config.*;

public class ProductDaoImpl {

    public static final String SELECT_PRODUCTS =
            "SELECT * FROM product";

    public static final String SAVE_PRODUCT =
            "INSERT INTO product (" +
                    "maker," +
                    "model," +
                    "type)" +
                    "VALUES (?, ?, ?)";

    public static final String UPDATE_PRODUCT =
            "UPDATE product SET maker = ?, model = ?, type = ? " +
                    "WHERE product_id = ?";

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
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_PRODUCTS)) {
            while (resultSet.next()) {
                result.add(findProducts(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private Product findProducts(ResultSet rs) throws SQLException {
        Product oneProduct = new Product();
        oneProduct.setProductId(rs.getLong("product_id"));
        oneProduct.setMaker(rs.getString("maker"));
        oneProduct.setModel(rs.getInt("model"));
        oneProduct.setType(rs.getString("type"));
        return oneProduct;
    }

    public Product saveProduct(Product product) {
        if (product.getProductId() == null) {
            try (Connection connection = getConnection();
                 PreparedStatement statement = connection.prepareStatement(SAVE_PRODUCT, Statement.RETURN_GENERATED_KEYS)) {
                connection.setAutoCommit(false);
                statement.setString(1, product.getMaker());
                statement.setInt(2, product.getModel());
                statement.setString(3, product.getType());
                statement.executeUpdate();
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    product.setProductId(rs.getLong(1));
                }
                rs.close();
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try (Connection connection = getConnection();
                 PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT)) {
                connection.setAutoCommit(false);
                statement.setString(1, product.getMaker());
                statement.setInt(2, product.getModel());
                statement.setString(3, product.getType());
                statement.setLong(4, product.getProductId());
                statement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return product;
    }
}

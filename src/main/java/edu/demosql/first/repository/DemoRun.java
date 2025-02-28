package edu.demosql.first.repository;

import edu.demosql.first.repository.dao.ProductDaoImpl;
import edu.demosql.first.repository.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class DemoRun {
    public static void main(String[] args) {
        Product product = new Product(2L,"N", 2222, "OldPhone2");
        ProductDaoImpl productDao = new ProductDaoImpl();
        productDao.saveProduct(product);

        ProductDaoImpl productDao2 = new ProductDaoImpl();
        List<Product> listProducts = productDao2.getAllProduct();
        for (Product prod : listProducts) {
            System.out.println(prod.toString());
        }
    }
}

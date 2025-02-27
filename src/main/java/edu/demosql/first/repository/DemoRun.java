package edu.demosql.first.repository;

import edu.demosql.first.repository.dao.ProductDaoImpl;
import edu.demosql.first.repository.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class DemoRun {
    public static void main(String[] args) {
//        Product product = new Product("N", 3438, "OldPhone10");
//        ProductDaoImpl productDao = new ProductDaoImpl();
//        productDao.saveProduct(product);

        ProductDaoImpl productDao = new ProductDaoImpl();
        List<Product> listProducts = new ArrayList<>();
        listProducts = productDao.getAllProduct();
        for (Product prod : listProducts) {
            System.out.println(prod);
        }
    }
}

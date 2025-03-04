package edu.demosql.first.repository;

import edu.demosql.first.repository.dao.ProductDaoImpl;
import edu.demosql.first.repository.domain.Product;

import java.util.List;

public class DemoRun {
    public static void main(String[] args) {

        ProductDaoImpl productDao1 = new ProductDaoImpl();
        productDao1.dropTableProduct();

        ProductDaoImpl productDao2 = new ProductDaoImpl();
        productDao2.createTableProduct();

        Product product3 = new Product("X", 444, "NewPhone1");
        ProductDaoImpl productDao3 = new ProductDaoImpl();
        productDao3.saveProduct(product3);

        Product product4 = new Product("Y", 555, "NewPhone2");
        ProductDaoImpl productDao4 = new ProductDaoImpl();
        productDao4.saveProduct(product4);

        Product product5 = new Product("Z", 777, "NewPhone3");
        ProductDaoImpl productDao5 = new ProductDaoImpl();
        productDao5.saveProduct(product5);

        ProductDaoImpl productDao6 = new ProductDaoImpl();
        productDao6.deleteOneProduct(2L);

        ProductDaoImpl productDao7 = new ProductDaoImpl();
        List<Product> listProducts = productDao7.getAllProduct();
        for (Product prod : listProducts) {
            System.out.println(prod.toString());
        }
    }
}

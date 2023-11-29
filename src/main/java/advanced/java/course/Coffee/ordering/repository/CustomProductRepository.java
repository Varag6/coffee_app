package advanced.java.course.Coffee.ordering.repository;

import advanced.java.course.Coffee.ordering.Domain.Product;
public interface CustomProductRepository {

    Product createProduct(Product product);
}

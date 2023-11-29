package advanced.java.course.Coffee.ordering.repository;
import advanced.java.course.Coffee.ordering.Controller.dto.ProductDto;
import advanced.java.course.Coffee.ordering.Domain.Category;
import advanced.java.course.Coffee.ordering.Domain.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomProductRepositoryImpl implements CustomProductRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    @Override
    @Transactional
    public Product createProduct(Product product) {
        Product newProduct = new Product();

        Optional<Category> existingCategory = categoryRepository.findById(product.getCategory().getCategory_id());
        if (existingCategory.isEmpty()) {
            throw new RuntimeException("Category not found");
        }

        Optional<Product> existingProduct = productRepository.findByName(product.getName());
        if (!existingProduct.isPresent()) {
            newProduct.setProduct_id(product.getProduct_id());
            newProduct.setName(product.getName());
            newProduct.setPrice(product.getPrice());
            newProduct.setCategory(product.getCategory());
            entityManager.persist(newProduct);
        }
        return newProduct;
    }
}

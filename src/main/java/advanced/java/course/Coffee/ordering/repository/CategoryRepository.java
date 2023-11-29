package advanced.java.course.Coffee.ordering.repository;

import advanced.java.course.Coffee.ordering.Domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findById(Integer categoryId);

    Optional<Category> findByName(String name);

    Optional<Category> findByIngredients(String ingredients);
}

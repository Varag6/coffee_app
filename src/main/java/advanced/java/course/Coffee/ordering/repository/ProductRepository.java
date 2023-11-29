package advanced.java.course.Coffee.ordering.repository;

import advanced.java.course.Coffee.ordering.Domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAll();
    Page<Product> findAll(Pageable page);

    Optional<Product> findByName(String name);


    Optional<Product> findById(Integer id);

    List<Product> findByPriceLessThan(Integer limit);




}

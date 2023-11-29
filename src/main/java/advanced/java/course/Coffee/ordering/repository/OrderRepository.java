package advanced.java.course.Coffee.ordering.repository;

import advanced.java.course.Coffee.ordering.Domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findById(int id);
}

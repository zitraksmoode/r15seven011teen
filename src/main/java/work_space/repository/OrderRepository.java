package work_space.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import work_space.model.Order;

public interface OrderRepository  extends JpaRepository<Order, Long> {
}

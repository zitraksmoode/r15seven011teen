package work_space.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import work_space.model.Order_item;

public interface Order_itemRepository extends JpaRepository<Order_item, Long> {
}

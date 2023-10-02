package work_space.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import work_space.model.Order_item;
import work_space.repository.Order_itemRepository;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class Order_itemService {
    private final Order_itemRepository orderItemRepository;

    @Autowired
    public Order_itemService(Order_itemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }
    public List<Order_item> findAll () {
        return orderItemRepository.findAll();
    }
    public Order_item findOne(Long id) {
        Optional<Order_item> foundOrder_item = orderItemRepository.findById(id);
        return foundOrder_item.orElse(null);
    }
    @Transactional
    public void save(Order_item orderItem) {
        orderItemRepository.save(orderItem);
    }
    @Transactional
    public void update(Long id , Order_item updatedOrderItem ){
        updatedOrderItem.setId(id);
        orderItemRepository.save(updatedOrderItem);
    }
    @Transactional
    public void deleted ( Long id) {
        orderItemRepository.deleteById(id);
    }
}

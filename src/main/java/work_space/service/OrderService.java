package work_space.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import work_space.model.Order;
import work_space.repository.OrderRepository;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final PersonService personService;
    private final ProductService productService;
    private final MagazineService magazineService;

    @Autowired
    public OrderService(OrderRepository orderRepository, PersonService personService, ProductService productService, MagazineService magazineService) {
        this.orderRepository = orderRepository;
        this.personService = personService;
        this.productService = productService;
        this.magazineService = magazineService;
    }
    public List<Order>  findAll () {
         return orderRepository.findAll();
    }
    public Order findOne (Long id) {
        Optional<Order> findOrder = orderRepository.findById(id);
        return findOrder.orElse(null);
    }
    @Transactional
    public void save (Order order) {
         orderRepository.save(order);
    }
    @Transactional
    public void update (Long id , Order updatedOrder ){
        updatedOrder .setId(id);
        orderRepository.save(updatedOrder);
    }
    @Transactional
    public void deleted (Long id) {
         orderRepository.deleteById(id);
    }

}

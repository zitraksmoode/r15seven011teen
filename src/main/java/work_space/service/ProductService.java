package work_space.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import work_space.model.Person;
import work_space.model.Product;
import work_space.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;


    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    public Product findOne(Long id) {
        Optional<Product> foundProduct = productRepository.findById(id);
        return foundProduct.orElse(null);
    }
    @Transactional
    public void save(Product product) {
        productRepository.save(product);
    }
    @Transactional
    public void update(Long id , Product updatedProduct){
        updatedProduct.setId(id);
        productRepository.save(updatedProduct);
    }
    @Transactional
    public void deleted (Long id) {
        productRepository.deleteById(id);
    }

}



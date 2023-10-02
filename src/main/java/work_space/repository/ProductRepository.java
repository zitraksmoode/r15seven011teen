package work_space.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import work_space.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

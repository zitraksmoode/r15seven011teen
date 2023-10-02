package work_space.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import work_space.model.Magazine;

import java.util.List;


public interface MagazineRepository extends JpaRepository<Magazine, Long> {
    List<Magazine> findMagazinesByPersonId(Long id);
}
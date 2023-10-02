package work_space.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import work_space.model.Magazine;

import work_space.repository.MagazineRepository;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class MagazineService {
     private final MagazineRepository magazineRepository;

     @Autowired
    public MagazineService(MagazineRepository magazineRepository) {
        this.magazineRepository = magazineRepository;
    }
    public List<Magazine> findAll () { //index
         return magazineRepository.findAll();
    }
    public Magazine findOne(Long id) { //show
        Optional<Magazine> foundMagazine = magazineRepository.findById(id);
        return foundMagazine.orElse(null);
    }
    @Transactional
    public void save(Magazine magazine) {
         magazineRepository.save(magazine);
    }
    @Transactional
    public void update(Long id , Magazine updatedMagazine )
    {
        updatedMagazine .setId(id);
        magazineRepository.save(updatedMagazine);
    }

    @Transactional
    public void delete(Long id) {
         magazineRepository.deleteById(id);
    }

}

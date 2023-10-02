    package work_space.service;


    import jakarta.persistence.EntityNotFoundException;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;
    import work_space.model.Magazine;
    import work_space.model.Person;
    import work_space.repository.MagazineRepository;
    import work_space.repository.PersonRepository;

    import java.util.List;
    import java.util.Optional;

    @Service
    @Transactional
    public class PersonService {
        private final PersonRepository personRepository;
        private final MagazineRepository magazineRepository;

    @Autowired
        public PersonService(PersonRepository personRepository, MagazineRepository magazineRepository) {
            this.personRepository = personRepository;
            this.magazineRepository = magazineRepository;
    }
        public List<Person> findAll() {
            return personRepository.findAll();
        }
        public Person findOne(Long id) {
           Optional<Person> foundPerson = personRepository.findById(id);
            return foundPerson.orElse(null);
        }
        @Transactional
        public void save(Person person) {
        personRepository.save(person);
        }
        @Transactional
        public void update(Long id, Person updatedPerson) {
            if (!personRepository.existsById(id)) {
                throw new EntityNotFoundException("Person not found");
            }
            updatedPerson.setId(id);
            personRepository.save(updatedPerson);
        }
        @Transactional
        public void deleted (Long id) {
        personRepository.deleteById(id);
        }
        public Optional<Person> getPersonByFullName(String full_name) {
            return personRepository.findPersonByFullName(full_name);
        }
        public List<Magazine> getMagazinesByPersonId(Long id) {
            return magazineRepository.findMagazinesByPersonId(id);
        }

    }

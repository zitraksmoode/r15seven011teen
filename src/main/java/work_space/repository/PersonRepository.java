    package work_space.repository;

    import org.springframework.data.jpa.repository.JpaRepository;
    import work_space.model.Person;

    import java.util.Optional;

    public interface PersonRepository extends JpaRepository<Person, Long> {
        Optional<Person> findPersonByFullName(String fullName);
    }

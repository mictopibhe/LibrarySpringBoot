package pl.davidduke.LibraryBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.davidduke.LibraryBoot.models.Person;

import java.util.Optional;

public interface PeopleRepository extends JpaRepository<Person, Integer> {
//Optional<Person> findByLastnameAndFirstname(Person person);
}

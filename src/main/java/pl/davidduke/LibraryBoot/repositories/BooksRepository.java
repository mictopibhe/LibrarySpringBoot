package pl.davidduke.LibraryBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.davidduke.LibraryBoot.models.Book;

public interface BooksRepository extends JpaRepository<Book, Integer> {
}

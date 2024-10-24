package hpclab.kcsatspringcommunity.myBook.repository;

import hpclab.kcsatspringcommunity.myBook.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByEmail(String email);
}

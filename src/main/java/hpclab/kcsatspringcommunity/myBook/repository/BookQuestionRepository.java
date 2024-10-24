package hpclab.kcsatspringcommunity.myBook.repository;

import hpclab.kcsatspringcommunity.myBook.domain.BookQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookQuestionRepository extends JpaRepository<BookQuestion, Long> {
}

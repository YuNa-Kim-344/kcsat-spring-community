package hpclab.kcsatspringcommunity.question.repository;

import hpclab.kcsatspringcommunity.question.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionJPARepository extends JpaRepository<Question, Long> {
    Question findById(long id);

    List<Question> findAllByShareCounterGreaterThan(Long limit);
}

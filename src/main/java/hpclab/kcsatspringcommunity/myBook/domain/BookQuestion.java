package hpclab.kcsatspringcommunity.myBook.domain;

import hpclab.kcsatspringcommunity.BaseTimeEntity;
import hpclab.kcsatspringcommunity.question.domain.Question;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookQuestion extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    public BookQuestion(Book book, Question question) {
        this.book = book;
        this.question = question;
    }
}
package hpclab.kcsatspringcommunity.myBook.service;

import hpclab.kcsatspringcommunity.myBook.domain.Book;
import hpclab.kcsatspringcommunity.myBook.domain.BookQuestion;
import hpclab.kcsatspringcommunity.myBook.dto.BookResponseForm;
import hpclab.kcsatspringcommunity.myBook.repository.BookRepository;
import hpclab.kcsatspringcommunity.question.domain.Choice;
import hpclab.kcsatspringcommunity.question.domain.Question;
import hpclab.kcsatspringcommunity.question.dto.QuestionResponseForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public void makeBook(String userEmail) {
        Book book = new Book(userEmail);
        bookRepository.save(book);
    }

    @Override
    public BookResponseForm findBook(String userEmail) {
        return BookToBookResponseForm(bookRepository.findByEmail(userEmail).orElseThrow(() -> new IllegalArgumentException("Member not found")));
    }

    private BookResponseForm BookToBookResponseForm(Book book) {
        return BookResponseForm.builder()
                .question(book.getBookQuestions().stream().map(this::questionToDto).toList())
                .build();
    }

    private QuestionResponseForm questionToDto(BookQuestion bookQuestion) {
        Question question = bookQuestion.getQuestion();

        return QuestionResponseForm.builder()
                .qId(question.getId())
                .questionType(question.getType().getKrName())
                .title(question.getTitle())
                .mainText(question.getMainText())
                .choices(question.getChoices().stream().map(Choice::getChoice).toList())
                .shareCounter(question.getShareCounter())
                .createdDate(question.getCreatedDate())
                .build();
    }
}

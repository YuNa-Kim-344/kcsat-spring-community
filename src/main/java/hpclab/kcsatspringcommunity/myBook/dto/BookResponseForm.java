package hpclab.kcsatspringcommunity.myBook.dto;

import hpclab.kcsatspringcommunity.question.dto.QuestionResponseForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class BookResponseForm {

    private List<QuestionResponseForm> question;
}
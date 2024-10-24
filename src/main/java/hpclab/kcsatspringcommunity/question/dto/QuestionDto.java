package hpclab.kcsatspringcommunity.question.dto;

import hpclab.kcsatspringcommunity.question.domain.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class QuestionDto {

    private QuestionType questionType;
    private String title;
    private String mainText;
    private List<String> choices;

    private String answer;
    private String translation;
    private String explanation;
}

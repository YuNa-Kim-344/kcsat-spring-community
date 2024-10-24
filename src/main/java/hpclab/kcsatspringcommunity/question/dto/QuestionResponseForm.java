package hpclab.kcsatspringcommunity.question.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponseForm {

    private Long qId;

    private String questionType;

    private String title;
    private String mainText;
    private List<String> choices;

    private LocalDateTime createdDate;

    private Long shareCounter;
}
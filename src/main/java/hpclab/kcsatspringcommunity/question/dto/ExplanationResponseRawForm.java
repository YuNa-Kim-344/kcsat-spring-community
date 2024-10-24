package hpclab.kcsatspringcommunity.question.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExplanationResponseRawForm {

    private String translation;
    private String explanation;
    private String answer;
}

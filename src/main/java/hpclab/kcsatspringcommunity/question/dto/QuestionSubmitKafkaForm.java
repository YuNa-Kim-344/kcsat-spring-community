package hpclab.kcsatspringcommunity.question.dto;

import lombok.Data;

@Data
public class QuestionSubmitKafkaForm {
    String definition;
    String mainText;

    public QuestionSubmitKafkaForm(String definition, String mainText) {
        this.definition = definition;
        this.mainText = mainText;
    }
}

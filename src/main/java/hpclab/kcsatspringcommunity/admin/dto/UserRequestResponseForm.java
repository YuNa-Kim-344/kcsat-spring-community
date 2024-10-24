package hpclab.kcsatspringcommunity.admin.dto;

import hpclab.kcsatspringcommunity.community.domain.Member;
import hpclab.kcsatspringcommunity.question.domain.Question;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestResponseForm {

    private RequestType type;
    private Member member;
    private Question question;
    private String content;
}

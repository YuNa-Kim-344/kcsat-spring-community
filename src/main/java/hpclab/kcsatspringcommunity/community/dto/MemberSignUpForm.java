package hpclab.kcsatspringcommunity.community.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MemberSignUpForm {

    private String email;
    private String username;
    private String password;
}

package hpclab.kcsatspringcommunity.community.service;

import hpclab.kcsatspringcommunity.community.dto.MemberSignUpForm;
import hpclab.kcsatspringcommunity.community.dto.MemberResponseForm;

import java.util.List;

public interface MemberService {

    void signUp(MemberSignUpForm memberSignUpForm);

    List<MemberResponseForm> findMembers();

    String findUsername(String userEmail);
}
package hpclab.kcsatspringcommunity.admin.service;

import hpclab.kcsatspringcommunity.admin.dto.UserRequestRequestForm;
import hpclab.kcsatspringcommunity.admin.dto.UserRequestResponseForm;

import java.util.List;

public interface UserRequestService {

    UserRequestResponseForm getQuestionErrorForm(Long qId, String email);

    UserRequestResponseForm getImprovingForm(UserRequestRequestForm form, String email);

    UserRequestResponseForm getETCForm(UserRequestRequestForm form, String email);

    UserRequestResponseForm saveUserRequest(UserRequestResponseForm form, String userEmail);

    List<UserRequestResponseForm> getUserRequests();
}

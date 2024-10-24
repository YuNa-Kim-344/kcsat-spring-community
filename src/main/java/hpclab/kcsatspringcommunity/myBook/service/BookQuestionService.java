package hpclab.kcsatspringcommunity.myBook.service;

import hpclab.kcsatspringcommunity.question.domain.Question;

public interface BookQuestionService {
    Long saveFirstQuestion(Question question, String userEmail);
    Long saveQuestion(Long qId, String userEmail);
}

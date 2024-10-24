package hpclab.kcsatspringcommunity.questionRank.service;

import hpclab.kcsatspringcommunity.question.dto.QuestionResponseForm;

import java.util.List;

public interface QuestionRankService {
    List<QuestionResponseForm> getRankedQuestions();
}

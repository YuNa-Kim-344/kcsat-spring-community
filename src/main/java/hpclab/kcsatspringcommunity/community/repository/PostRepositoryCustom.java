package hpclab.kcsatspringcommunity.community.repository;

import hpclab.kcsatspringcommunity.community.domain.Post;
import hpclab.kcsatspringcommunity.question.domain.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRepositoryCustom {
    Page<Post> findPostsByQuestionTypeAndTitle(Pageable pageable, String title, QuestionType type);
    Page<Post> findHotPosts(Pageable pageable);
    Page<Post> findHotPostsByQuestionTypeAndTitle(Pageable pageable, String title, QuestionType type);
}

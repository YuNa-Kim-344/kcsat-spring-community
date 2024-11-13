package hpclab.kcsatspringcommunity.community.dto;


import hpclab.kcsatspringcommunity.community.domain.Post;
import hpclab.kcsatspringcommunity.question.domain.Question;
import hpclab.kcsatspringcommunity.question.dto.QuestionDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PostResponseForm {

    private Long pId;

    private String title;
    private String content;

    private LocalDateTime postDate;

    private String email;
    private String username;

    private String questionType;

    private QuestionDetailsDto question;

    private Long postViewCount;

    @Builder
    public PostResponseForm(Post post, Long postViewCount) {
        this.pId = post.getPId();
        this.title = post.getPostTitle();
        this.content = post.getPostContent();
        this.postDate = post.getCreatedDate();
        this.email = post.getMember().getEmail();
        this.username = post.getMember().getUsername();
        this.postViewCount = postViewCount;

        Question question = post.getQuestion();

        if (question == null) {
            this.questionType = "";
        }
        else {
            this.questionType = question.getType().getKrName();
            this.question = new QuestionDetailsDto(question);
        }
    }

    public PostResponseForm(Post post) {
        this.pId = post.getPId();
        this.title = post.getPostTitle();
        this.content = post.getPostContent();
        this.postDate = post.getCreatedDate();
        this.email = post.getMember().getEmail();
        this.username = post.getMember().getUsername();

        Question question = post.getQuestion();

        if (question == null) {
            this.questionType = "";
        }
        else {
            this.questionType = question.getType().getKrName();
            this.question = new QuestionDetailsDto(question);
        }
    }
}

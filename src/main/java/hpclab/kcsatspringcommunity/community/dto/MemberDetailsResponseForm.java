package hpclab.kcsatspringcommunity.community.dto;

import hpclab.kcsatspringcommunity.community.domain.Member;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MemberDetailsResponseForm {

    private Long mId;
    private String email;
    private String username;
    private LocalDateTime createdDate;
    private List<PostResponseForm> posts;
    private List<CommentResponseForm> comments;

    @Builder
    public MemberDetailsResponseForm(Member member) {
        this.mId = member.getMID();
        this.email = member.getEmail();
        this.username = member.getUsername();
        this.createdDate = member.getCreatedDate();
        this.posts = member.getPosts().stream().map(PostResponseForm::new).toList();
        this.comments = member.getComments().stream().map(CommentResponseForm::new).toList();
    }
}

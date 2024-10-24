package hpclab.kcsatspringcommunity.community.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PostDetailForm {
    private PostResponseForm post;
    private List<CommentResponseForm> hotComments;
    private List<String> hotCommentsUpVoteCounter;
    private List<String> hotCommentsDownVoteCounter;
    private List<CommentResponseForm> comments;
    private List<String> commentsUpVoteCounter;
    private List<String> commentsDownVoteCounter;
}

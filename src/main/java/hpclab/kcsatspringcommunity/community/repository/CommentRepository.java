package hpclab.kcsatspringcommunity.community.repository;

import hpclab.kcsatspringcommunity.community.domain.Comment;
import hpclab.kcsatspringcommunity.community.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
}

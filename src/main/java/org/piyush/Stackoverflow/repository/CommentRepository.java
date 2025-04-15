package org.piyush.Stackoverflow.repository;

import java.util.List;

import org.piyush.Stackoverflow.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByUserId(Long userId);
    List<Comment> findByAnswerId(Long answerId);
    List<Comment> findByCommentTextContaining(String commentText);
    List<Comment> findByAnswerIdAndUserId(Long answerId, Long userId);  
    List<Comment> findByAnswerIdAndCommentTextContaining(Long answerId, String commentText); 
}

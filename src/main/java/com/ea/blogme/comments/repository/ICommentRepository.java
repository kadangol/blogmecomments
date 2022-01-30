package com.ea.blogme.comments.repository;

import com.ea.blogme.comments.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByParentCommentIsNull();
    List<Comment> findAllByBlogIdAndParentCommentIsNull(Long blogId);
}

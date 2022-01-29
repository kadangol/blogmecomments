package com.ea.blogme.comments.service;

import com.ea.blogme.comments.dto.CommentInputDto;
import com.ea.blogme.comments.exceptionhandler.exceptions.CustomException;
import com.ea.blogme.comments.models.Comment;
import com.ea.blogme.comments.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CommentService {
    @Autowired
    private ICommentRepository commentRepository;

    public List<Comment> findAll() {
        return commentRepository.findAllByParentCommentIsNull();
    }

    public Comment findById(Long id) {
        var a = commentRepository.findById(id);
        return a.get();
    }

    public Comment save(CommentInputDto commentDto) {
        Optional<Comment> parentComment = null;
        if (commentDto.getParentId() != null && commentDto.getParentId() > 0) {
            parentComment = commentRepository.findById(commentDto.getParentId());
            if (parentComment.orElse(null) == null)
                throw new CustomException("Parent comment not found.");
        }
        var comment = new Comment(commentDto.getBlogId(), commentDto.getCommentText(), false, new Date(), null, null);
        comment.setParentComment(parentComment == null ? null : parentComment.get());
        commentRepository.save(comment);
        return comment;
    }

    public Comment update(CommentInputDto CommentUpdate, Long id) {
        return null;

    }

    @Transactional
    @Modifying
    public String delete(Long id) {

        commentRepository.deleteById(id);
        return "Comment Deleted.";
    }
}

package com.ea.blogme.comments.service;

import com.ea.blogme.comments.dao.ICommentDao;
import com.ea.blogme.comments.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
@Transactional
public class CommentService {
    @Autowired
    private ICommentDao commentDao;

    public List<Comment> getAll() {
        return commentDao.getAll();
    }

    public void add(Comment comment) {
        commentDao.add(comment);
    }

    public Long save(Comment comment){
        commentDao.add(comment);
        return comment.getId();
    }

    public Comment get(Long id) {
        return commentDao.get(id);
    }

    public void update(Comment comment) {
        commentDao.update(comment);
    }

    public void delete(Long id) {
        commentDao.delete(id);
    }
}

package com.ea.blogme.comments.dao;

import com.ea.blogme.comments.models.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class CommentDao implements ICommentDao{
    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Comment> getAll() {
        return em.createQuery("select c from Comment c", Comment.class).getResultList();
    }

    @Override
    public void add(Comment Comment) {
        em.persist(Comment);
    }

    @Override
    public Comment get(Long id) {
        return em.find(Comment.class, id);
    }

    @Override
    public void update(Comment comment) {
        em.merge(comment);
    }

    @Override
    public void delete(Long commentId) {
        Comment c = em.getReference(Comment.class, commentId);
        em.remove(c);
    }
}

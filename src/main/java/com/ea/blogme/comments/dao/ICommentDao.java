package com.ea.blogme.comments.dao;

import com.ea.blogme.comments.models.Comment;

import java.util.List;

public interface ICommentDao {
    public abstract List<Comment> getAll();

    public abstract void add(Comment comment);

    public abstract Comment get(Long id);

    public abstract void update(Comment comment);

    public abstract void delete(Long comment);
}

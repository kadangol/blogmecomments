package com.ea.blogme.comments.controller;

import com.ea.blogme.comments.models.Comment;
import com.ea.blogme.comments.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@RestController
@RequestMapping("/comment")
public class CommentRestController {
    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getAll() {
        return commentService.getAll();
    }

    @GetMapping("/{id}")
    public Comment get(@PathVariable Long id) {
        return commentService.get(id);
    }

    @PostMapping
    public RedirectView add(@RequestBody Comment comment) {
        long id = commentService.save(comment);
        return new RedirectView("/comment/" + id);
    }

    @PutMapping
    public void update(@RequestBody Comment comment) {
        commentService.update(comment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        commentService.delete(id);
    }
}

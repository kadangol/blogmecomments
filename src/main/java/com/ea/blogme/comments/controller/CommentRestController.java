package com.ea.blogme.comments.controller;

import com.ea.blogme.comments.dto.CommentInputDto;
import com.ea.blogme.comments.dto.CommentUpdateDto;
import com.ea.blogme.comments.models.Comment;
import com.ea.blogme.comments.service.CommentService;
import com.ea.blogme.comments.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/comment")
public class CommentRestController {
    @Autowired
    private CommentService commentService;

    @GetMapping
    @JsonView({View.ChildOnly.class})
    public List<Comment> getAll() {
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    @JsonView({View.ChildOnly.class})
    public Comment get(@PathVariable Long id) {
        return commentService.findById(id);
    }

    @PostMapping
    @JsonView({View.ChildOnly.class})
    public Comment add(@Valid @RequestBody CommentInputDto comment) {
        return commentService.save(comment);
    }

    @PutMapping("/{id}")
    @JsonView({View.ChildOnly.class})
    public Comment update(@Valid @RequestBody CommentUpdateDto commentDto, @PathVariable Long id) {
        return commentService.update(commentDto, id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return commentService.delete(id);
    }

    @GetMapping("/blog/{blogId}")
    @JsonView({View.ChildOnly.class})
    public List<Comment> getAllByBlogId(@PathVariable Long blogId) {
        return commentService.findByBlogId(blogId);
    }
}

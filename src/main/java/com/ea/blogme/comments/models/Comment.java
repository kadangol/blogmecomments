package com.ea.blogme.comments.models;

import com.ea.blogme.comments.view.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue
    @JsonView({View.ChildOnly.class})
    private Long id;
    @JsonView({View.ChildOnly.class})
    private Long blogId;
    @NotBlank
    @JsonView({View.ChildOnly.class})
    private String commentText;
    @JsonView({View.ChildOnly.class})
    private boolean isDeleted;
    @JsonView({View.ChildOnly.class})
    private Date createdDate;
    @JsonView({View.ChildOnly.class})
    private Date modifiedDate;
    @JsonView({View.ChildOnly.class})
    private Date deletedDate;


    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "parent_id")
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment", cascade = {CascadeType.ALL})
    @JsonView({View.ChildOnly.class})
    private Set<Comment> childComment = new HashSet<Comment>();


    public Comment(Long blogId, String commentText, boolean isDeleted, Date createdDate, Date modifiedDate, Date deletedDate) {
        this.blogId = blogId;
        this.commentText = commentText;
        this.isDeleted = isDeleted;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.deletedDate = deletedDate;
    }
}

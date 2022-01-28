package com.ea.blogme.comments.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
//    @NotNull
    private Long blogId;
    @NotBlank
    private String commentText;
    private boolean isDeleted;
    private Date createdDate;
    private Date modifiedDate;
    private Date deletedDate;

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }
}

package com.ea.blogme.comments.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentInputDto {
    private Long id;
    private Long blogId;
    private String commentText;
    private Long parentId;
}

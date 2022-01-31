package com.ea.blogme.comments.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentUpdateDto {
    @NotBlank
    private String commentText;
    @NotNull
    private Long userId;
}

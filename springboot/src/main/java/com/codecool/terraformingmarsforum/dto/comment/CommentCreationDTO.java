package com.codecool.terraformingmarsforum.dto.comment;

import com.codecool.terraformingmarsforum.model.AppUser;
import com.codecool.terraformingmarsforum.model.types.PostType;
import lombok.*;

import java.util.Date;

/**
 * DTO for comment creation. Contains all data for comments, postType and postId. */
@Data
@Builder
public class CommentCreationDTO {

    @NonNull
    private AppUser user;
    @NonNull
    private String description;
    @NonNull
    private Date timeStamp;
    @NonNull
    private Long postId;
    @NonNull
    private PostType postType;
}

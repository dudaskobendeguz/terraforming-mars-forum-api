package com.codecool.terraformingmarsforum.dto.comment;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
@Builder
public class CommentUpdateDTO {

    @NonNull
    private Long id;
    @NonNull
    private String description;
    @NonNull
    private Boolean isTimestampOverride;
    private Date timeStamp;
}

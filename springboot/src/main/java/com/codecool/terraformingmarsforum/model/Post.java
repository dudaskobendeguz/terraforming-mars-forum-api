package com.codecool.terraformingmarsforum.model;

import com.codecool.terraformingmarsforum.model.types.PostType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Post {
    private final int id;
    private String title;
    private String description;
    private PostType type;
    private String author;
}

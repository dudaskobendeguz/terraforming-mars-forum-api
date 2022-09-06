package com.codecool.terraformingmarsforum.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Comment {

    private int id;
    private String description;
    private AppUser appUser;
}

package com.codecool.terraformingmarsforum.model;

import com.codecool.terraformingmarsforum.model.types.PostType;

public class UserPost extends Post {
    public UserPost(int id, String title, String description, PostType type, String author) {
        super(id, title, description, type, author);
    }
}

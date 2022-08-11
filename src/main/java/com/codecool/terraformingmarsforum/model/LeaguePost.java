package com.codecool.terraformingmarsforum.model;

import com.codecool.terraformingmarsforum.model.types.PostType;

public class LeaguePost extends Post {
    public LeaguePost(int id, String title, String description, PostType type, String author) {
        super(id, title, description, type, author);
    }
}

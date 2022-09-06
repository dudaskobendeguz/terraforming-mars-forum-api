package com.codecool.terraformingmarsforum.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppUser {
    private int id;
    private String name;
    private String password;
    private String nickname;
    private String imgUrl;
}

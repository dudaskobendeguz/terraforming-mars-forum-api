package com.codecool.terraformingmarsforum.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {
    private int id;
    private String name;
    private String password;
    private String nickName;
    private String imgUrl;
}

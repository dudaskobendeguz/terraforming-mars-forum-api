package com.codecool.terraformingmarsforum.security.jwt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UsernameAndPasswordAuthenticationRequest {

    private String username;
    private String password;
}

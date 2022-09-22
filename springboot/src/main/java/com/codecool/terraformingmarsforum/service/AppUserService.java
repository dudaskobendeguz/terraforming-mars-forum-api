package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.model.AppUser;
import com.codecool.terraformingmarsforum.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AppUserService  implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = getAppUserByUsernameOrEmail(username);
        return new User(appUser.getUsername(), appUser.getPassword(), getUserRoles(appUser));
    }

    private Set<SimpleGrantedAuthority> getUserRoles(AppUser appUser){
        Set<SimpleGrantedAuthority> roles = new HashSet<>();
        appUser.getRoles().forEach(role -> roles.add(new SimpleGrantedAuthority(role.name())));
        return roles;
    }

    public AppUser getAppUserById(Long id) {
        return appUserRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("User not found with id: '%d'!".formatted(id))
        );
    }

    /**
     * This method tries to get a user from the DB using username or email.
     * Any valid username OR email is acceptable
     * @param userData username or email of the user
     * @return AppUser Object if username or email is exists, throws NoSuchElementException anyway
     */
    public AppUser getAppUserByUsernameOrEmail(String userData) {
        return appUserRepository.findAppUserByUsernameOrEmail(userData, userData).orElseThrow(() ->
                new NoSuchElementException(
                        "User not found with username/email: '%s'!".formatted(userData)
                )
        );
    }
}

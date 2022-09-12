package com.codecool.terraformingmarsforum.service;

import com.codecool.terraformingmarsforum.model.Comment;
import com.codecool.terraformingmarsforum.model.UserPost;
import com.codecool.terraformingmarsforum.repository.AppUserRepository;
import com.codecool.terraformingmarsforum.repository.UserPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.codecool.terraformingmarsforum.model.AppUser;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserPostService {

    private final UserPostRepository userPostRepository;
    private final AppUserRepository appUserRepository;

    /**
     * Returns a {@link UserPost} if present, otherwise throws {@link NoSuchElementException}.
     *
     * @param id the id of the requested {@link UserPost}
     * @return the requested {@link UserPost}
     * @throws NoSuchElementException if {@link UserPost} with corresponding id is not found
     */
    private UserPost getUserPostById(Long id) {
        return userPostRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    /**
     * @return every {@link UserPost} entry in the database.
     */
    public List<UserPost> getAllUserPosts() {
        return userPostRepository.findAll();
    }

    /**
     * Creates an entry of a newly created {@link UserPost} in the database.
     * Returns the newly created {@link UserPost} if corresponding {@link AppUser} is found, otherwise
     * throws {@link IllegalArgumentException}.
     *
     * @param userPost data of {@link UserPost} to be created
     * @return the newly created {@link UserPost}
     * @throws IllegalArgumentException if {@link AppUser} is not found
     */
    public UserPost addUserPost(UserPost userPost) {
        Long userId = userPost.getUser().getId();
        userPost.setUser(appUserRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("User: %d not found".formatted(userId))
        ));
        userPost.setTimestamp(new Date());
        return userPostRepository.save(userPost);
    }

    /**
     * Updates {@link UserPost} in the database if exists, otherwise throws {@link NoSuchElementException}.
     *
     * @param id of {@link UserPost} to be updated
     * @param updatedUserPost the updated information of {@link UserPost}
     * @throws NoSuchElementException if {@link UserPost} is not found
     */
    public void updateUserPost(Long id, UserPost updatedUserPost) {
        UserPost userPost = getUserPostById(id);
        userPost.setDescription(updatedUserPost.getDescription());
        userPostRepository.save(userPost);
    }

    public void deleteUserPost(Long id) {
        getUserPostById(id); // check if user post is present
        userPostRepository.deleteById(id);
    }

    public void addCommentToPostByPostId(Long id, Comment comment) {
        UserPost userPost = getUserPostById(id);
        userPost.getComments().add(comment);
        userPostRepository.save(userPost);
    }
}

package com.social.media.service;

import com.social.media.model.User;
import com.social.media.repostory.PostRepository;
import com.social.media.repostory.ProfileRepository;
import com.social.media.repostory.SocialGroupRepository;
import com.social.media.repostory.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SocialService {

    private final SocialGroupRepository socialGroupRepository;
    private final PostRepository postRepository;
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        if (user.getSocialProfile() != null) {
            user.getSocialProfile().setUser(user);
        }
        return userRepository.save(user);
    }

    public User deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
        return user;
    }
}

package com.social.media.config;

import com.social.media.model.Post;
import com.social.media.model.Profile;
import com.social.media.model.SocialGroup;
import com.social.media.model.User;
import com.social.media.repostory.PostRepository;
import com.social.media.repostory.ProfileRepository;
import com.social.media.repostory.SocialGroupRepository;
import com.social.media.repostory.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final SocialGroupRepository socialGroupRepository;
    private final PostRepository postRepository;
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    @Bean
    public CommandLineRunner initializeData() {
        return args -> {
            // Create some user
            User user1 = new User();
            User user2 = new User();
            User user3 = new User();

            // Save users to the database
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

            // Create some groups
            SocialGroup socialGroup1 = new SocialGroup();
            SocialGroup socialGroup2 = new SocialGroup();

            // Add users to groups
            socialGroup1.getUsers().add(user1);
            socialGroup1.getUsers().add(user2);

            socialGroup2.getUsers().add(user2);
            socialGroup2.getUsers().add(user3);

            // Save groups to the database
            socialGroupRepository.save(socialGroup1);
            socialGroupRepository.save(socialGroup2);

            // Associate users with groups
            user1.getGroups().add(socialGroup1);
            user2.getGroups().add(socialGroup1);
            user2.getGroups().add(socialGroup2);
            user3.getGroups().add(socialGroup2);

            // Save users back to database to update associations
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

            // Create some posts
            Post post1 = new Post();
            Post post2 = new Post();
            Post post3 = new Post();

            // Associate posts with users
            post1.setUser(user1);
            post2.setUser(user2);
            post3.setUser(user3);

            // Save posts to the database (assuming you have a PostRepository)
            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);

            // Create some social profiles
            Profile profile1 = new Profile();
            Profile profile2 = new Profile();
            Profile profile3 = new Profile();

            // Associate profiles with users
            profile1.setUser(user1);
            profile2.setUser(user2);
            profile3.setUser(user3);

            // Save profiles to the database (assuming you have a SocialProfileRepository)
            profileRepository.save(profile1);
            profileRepository.save(profile2);
            profileRepository.save(profile3);

            // FETCH TYPES
            System.out.println("\n*********** FETCHING SOCIAL USER ***********\n");
            userRepository.findById(1L);
        };
    }
}

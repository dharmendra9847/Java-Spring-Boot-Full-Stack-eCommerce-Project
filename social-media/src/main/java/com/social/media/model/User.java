package com.social.media.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "social_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @OneToOne
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    @OneToOne(mappedBy = "user", cascade = CascadeType.PERSIST)
//    @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
//    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
//    @OneToOne(mappedBy = "user", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @OneToOne(mappedBy = "user", cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE})
    //@JoinColumn(name = "social_profile_id")
    private Profile socialProfile;

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    //    @ManyToMany(fetch = FetchType.EAGER)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_group",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<SocialGroup> groups = new HashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Custom setter
    public void setSocialProfile(Profile socialProfile) {
        this.socialProfile = socialProfile;

        if (socialProfile != null) {
            socialProfile.setUser(this);
        }
    }
}

package com.social.media.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @OneToOne(mappedBy = "socialProfile")
    @OneToOne
    @JoinColumn(name = "social_user")
    @JsonIgnore
    private User user;

    private String description;

    // Custom setter
//    public void setUser(User user) {
//        this.user = user;
//        if (user.getSocialProfile() != this) {
//            user.setSocialProfile(this);
//        }
//    }
}

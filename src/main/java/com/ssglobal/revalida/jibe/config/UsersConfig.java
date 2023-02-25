package com.ssglobal.revalida.jibe.config;


import com.ssglobal.revalida.jibe.model.Post;
import com.ssglobal.revalida.jibe.model.Role;
import com.ssglobal.revalida.jibe.model.User;
import com.ssglobal.revalida.jibe.repository.PostRepository;
import com.ssglobal.revalida.jibe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class UsersConfig {
    private final PasswordEncoder passwordEncoder;
    @Bean
    CommandLineRunner commandLineRunnerUsers(UserRepository userRepository, PostRepository postRepository) {

        return args -> {
            User user1 = User.builder()
                    .firstname("Jim Lloyd")
                    .lastname("De Guzman")
                    .username("jimlloyddg")
                    .email("jimlloyddeguzman60@gmail.com")
                    .password(passwordEncoder.encode("Jimlloyddg1@"))
                    .bio("Inverse full-range flexibility")
                    .imageUrl("http://dummyimage.com/200x200.png/9933ff/ffffff")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            User user2 = User.builder()
                    .firstname("Marionne")
                    .lastname("Quintana")
                    .username("mQuintana")
                    .email("mquintana@gmail.com")
                    .password(passwordEncoder.encode("Marionne1@"))
                    .bio("Synergistic 24 hour intranet")
                    .imageUrl("http://dummyimage.com/200x200.png/33fff5/ffffff")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            User user3 = User.builder()
                    .firstname("Sharline")
                    .lastname("Mattholie")
                    .username("smattholie0")
                    .email("smattholie@gmail.com")
                    .password(passwordEncoder.encode("Sharline2255@"))
                    .bio("Universal coherent moderator")
                    .imageUrl("http://dummyimage.com/200x200.png/33ff5f/ffffff")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            User user4 = User.builder()
                    .firstname("Oren")
                    .lastname("Gorgen")
                    .username("ogorgen0")
                    .email("ogorgen@gmail.com")
                    .password(passwordEncoder.encode("Oren2255@"))
                    .bio("Organized fault-tolerant flexibility")
                    .imageUrl("http://dummyimage.com/200x200.png/ff4133/ffffff")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            User user5 = User.builder()
                    .firstname("John")
                    .lastname("Doe")
                    .username("admin")
                    .email("admin@gmail.com")
                    .password(passwordEncoder.encode("Admin2255!"))
                    .bio("Extended interactive synergy")
                    .imageUrl("")
                    .firstTimeLogin(true)
                    .role(Role.USER)
                    .build();

            List<User> users =List.of(user1,user2,user3,user4,user5);

            userRepository.saveAll(users);


            Post p1 = Post.builder().body("Post Body 1").datePosted(LocalDate.now()).imageUrl("picsum.photos/200").user(userRepository.findById(10000).get()).build();

            Post p2 = Post.builder().body("Post Body 2").datePosted(LocalDate.now()).imageUrl("picsum.photos/200").user(userRepository.findById(10000).get()).build();

            Post p3 = Post.builder().body("Post Body 3").datePosted(LocalDate.now().minusDays(1)).imageUrl("picsum.photos/200").user(userRepository.findById(10001).get()).build();

            Post p4 = Post.builder().body("Post Body 4").datePosted(LocalDate.now().minusDays(1)).imageUrl("picsum.photos/200").user(userRepository.findById(10002).get()).build();

            Post p5 = Post.builder().body("Post Body 5").datePosted(LocalDate.now().minusDays(2)).imageUrl("picsum.photos/200").user(userRepository.findById(10002).get()).build();

            Post p6 = Post.builder().body("Post Body 6").datePosted(LocalDate.now().minusDays(2)).imageUrl("picsum.photos/200").user(userRepository.findById(10003).get()).build();

            Post p7 = Post.builder().body("Post Body 7").datePosted(LocalDate.now().minusDays(5)).imageUrl("picsum.photos/200").user(userRepository.findById(10004).get()).build();

            List<Post> posts = List.of(p1, p2, p3, p4, p5, p6, p7);

            postRepository.saveAll(posts);
        };
    }

}
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
                    .firstname("Georgie")
                    .lastname("Furnell")
                    .username("gfurnell0")
                    .email("gfurnell@gmail.com")
                    .password(passwordEncoder.encode("Georgie2255"))
                    .bio("Inverse full-range flexibility")
                    .imageUrl("http://dummyimage.com/239x201.png/cc0000/ffffff")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            User user2 = User.builder()
                    .firstname("Suzie")
                    .lastname("Varey")
                    .username("svarey0")
                    .email("svarey@gmail.com")
                    .password(passwordEncoder.encode("Suzie2255"))
                    .bio("Synergistic 24 hour intranet")
                    .imageUrl("http://dummyimage.com/239x201.png/cc0000/ffffff")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            User user3 = User.builder()
                    .firstname("Sharline")
                    .lastname("Mattholie")
                    .username("smattholie0")
                    .email("smattholie@gmail.com")
                    .password(passwordEncoder.encode("Sharline2255"))
                    .bio("Universal coherent moderator")
                    .imageUrl("http://dummyimage.com/239x201.png/cc0000/ffffff")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            User user4 = User.builder()
                    .firstname("Oren")
                    .lastname("Gorgen")
                    .username("ogorgen0")
                    .email("ogorgen@gmail.com")
                    .password(passwordEncoder.encode("Oren2255"))
                    .bio("Organized fault-tolerant flexibility")
                    .imageUrl("http://dummyimage.com/239x201.png/cc0000/ffffff")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            User user5 = User.builder()
                    .firstname("John")
                    .lastname("Doe")
                    .username("admin")
                    .email("admin@gmail.com")
                    .password(passwordEncoder.encode("admin2255"))
                    .bio("Extended interactive synergy")
                    .imageUrl("http://dummyimage.com/239x201.png/cc0000/ffffff")
                    .firstTimeLogin(false)
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
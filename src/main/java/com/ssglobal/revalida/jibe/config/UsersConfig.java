package com.ssglobal.revalida.jibe.config;

import com.ssglobal.revalida.jibe.model.Role;
import com.ssglobal.revalida.jibe.model.User;
import com.ssglobal.revalida.jibe.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class UsersConfig {
    private final PasswordEncoder passwordEncoder;
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {

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
        };
    }

}

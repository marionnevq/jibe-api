package com.ssglobal.revalida.jibe.config;


import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ssglobal.revalida.jibe.model.Comment;
import com.ssglobal.revalida.jibe.model.Post;
import com.ssglobal.revalida.jibe.model.Role;
import com.ssglobal.revalida.jibe.model.User;
import com.ssglobal.revalida.jibe.repository.CommentRepository;
import com.ssglobal.revalida.jibe.repository.PostRepository;
import com.ssglobal.revalida.jibe.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class UsersConfig {
    private final PasswordEncoder passwordEncoder;
    @Bean
    CommandLineRunner commandLineRunnerUsers(UserRepository userRepository, PostRepository postRepository,
    		CommentRepository commentRepository) {

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
            
            User ice = User.builder()
                    .firstname("Christian")
                    .lastname("Alday")
                    .username("Icesxz")
                    .email("christian.alday@gmail.com")
                    .password(passwordEncoder.encode("admin2255"))
                    .bio("If I get takot, would you hawak me tight?\r\n"
                    		+ "If I gawa something mali, would you make it right?\r\n"
                    		+ "If I build an apoy, would you bantay the flame?\r\n"
                    		+ "If I sabi I miss you, would you ramdam the same?")
                    .imageUrl("https://www.facebook.com/photo/?fbid=2332926670067790&set=a.153198421373970")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            
            User jim = User.builder()
                    .firstname("Jim Lloyd")
                    .lastname("De Guzman")
                    .username("Jimsxz")
                    .email("jimlloyddeguzman60@gmail.com")
                    .password(passwordEncoder.encode("admin2255"))
                    .bio("Kung ayaw mong mainlove ng todo\r\n"
                    		+ "Ay huwag mo ng susubukang tingnan pa ako,\r\n"
                    		+ "dahil baka mabaliw ka ng husto!!\r\n"
                    		+ "")
                    .imageUrl("https://www.facebook.com/photo/?fbid=5844522632303797&set=a.111122295643888&__tn__=%3C")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            
            User mars = User.builder()
                    .firstname("Marionne")
                    .lastname("Quintana")
                    .username("Marszx")
                    .email("quintanamarionne@gmail.com")
                    .password(passwordEncoder.encode("Admin2255!"))
                    .bio("Tao ka ba?..............\r\n"
                    		+ "naninigurado lang. boom")
                    .imageUrl("https://www.facebook.com/photo/?fbid=5608656919168662&set=a.147189011982174&__tn__=%3C")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            
            User nikki = User.builder()
                    .firstname("Krishna Nicole")
                    .lastname("Fagara")
                    .username("Nikki143")
                    .email("krishnanicolefagara@gmail.com")
                    .password(passwordEncoder.encode("admin2255"))
                    .bio("“In a relationship”\r\n"              		
                    		+ "Charr. Kinabahan yung may gusto sakin")
                    .imageUrl("https://www.facebook.com/photo/?fbid=5143306602456035&set=a.112784658841613")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            
            User jayann = User.builder()
                    .firstname("Jay-Ann")
                    .lastname("Oliveros")
                    .username("jayannisdname")
                    .email("jayann20oliveros@gmail.com")
                    .password(passwordEncoder.encode("admin2255"))
                    .bio("Kahit anong suot mo, mas bagay parin ako sayo.")
                    .imageUrl("https://www.facebook.com/photo/?fbid=2249309448595490&set=a.113383658854757")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            
            List<User> users =List.of(user1,user2,user3,user4,user5,ice, jim, mars, nikki, jayann);

            userRepository.saveAll(users);


            Post p1 = Post.builder().body("Post Body 1").datePosted(LocalDate.now()).imageUrl("https://cdn.britannica.com/36/123536-050-95CB0C6E/Variety-fruits-vegetables.jpg?w=400&h=300&c=crop").user(userRepository.findById(10000).get()).build();

            Post p2 = Post.builder().body("Post Body 2").datePosted(LocalDate.now()).user(userRepository.findById(10000).get()).build();

            Post p3 = Post.builder().body("Post Body 3").datePosted(LocalDate.now().minusDays(1)).imageUrl("picsum.photos/200").user(userRepository.findById(10001).get()).build();

            Post p4 = Post.builder().body("Post Body 4").datePosted(LocalDate.now().minusDays(1)).imageUrl("picsum.photos/200").user(userRepository.findById(10002).get()).build();

            Post p5 = Post.builder().body("Post Body 5").datePosted(LocalDate.now().minusDays(2)).imageUrl("picsum.photos/200").user(userRepository.findById(10002).get()).build();

            Post p6 = Post.builder().body("Post Body 6").datePosted(LocalDate.now().minusDays(2)).imageUrl("picsum.photos/200").user(userRepository.findById(10003).get()).build();

            Post p7 = Post.builder().body("Post Body 7").datePosted(LocalDate.now().minusDays(5)).imageUrl("picsum.photos/200").user(userRepository.findById(10004).get()).build();

            Post p8 = Post.builder().body("ahh, geh, luh. \r\n"
            		+ "yan yung pambansang ibon pre.").datePosted(LocalDate.now().minusDays(9)).imageUrl("https://media.tenor.com/SM55NxnE6_kAAAAM/lick-boy-lick.gif").user(userRepository.findById(10005).get()).build();

            
            List<Post> posts = List.of(p1, p2, p3, p4, p5, p6, p7, p8);

            postRepository.saveAll(posts);
            
            Comment c1 = Comment.builder()
	    		.dateCommented(LocalDate.now())
	    		.media("https://media.moddb.com/cache/images/members/5/4550/4549205/thumb_620x2000/duck.jpg")
	    		.value("This is banana.")
	    		.post(postRepository.findById(2).get())
	    		.user(userRepository.findById(10003).get()).build();
           
            Comment c2 = Comment.builder()
    	    		.dateCommented(LocalDate.now())
    	    		.media("https://pbs.twimg.com/profile_images/1074985128881864704/-WV56RC5_400x400.jpg")
    	    		.value("This is hatdog.")
    	    		.post(postRepository.findById(1).get())
    	    		.user(userRepository.findById(10001).get()).build();
            
            Comment c3 = Comment.builder()
    	    		.dateCommented(LocalDate.now())
    	    		.media("https://pbs.twimg.com/profile_images/653700295395016708/WjGTnKGQ_400x400.png")
    	    		.value("Wow nice banana.")
    	    		.post(postRepository.findById(2).get())
    	    		.user(userRepository.findById(10002).get()).build();
            
            Comment c4 = Comment.builder()
    	    		.dateCommented(LocalDate.now())
    	    		.media("https://media.tenor.com/9ModG8XWV5AAAAAd/puss-in.gif")
    	    		.value("Can you dm me this photo?")
    	    		.post(postRepository.findById(2).get())
    	    		.user(userRepository.findById(10004).get()).build();
            
            Comment c5 = Comment.builder()
    	    		.dateCommented(LocalDate.now())
    	    		.media("https://media.tenor.com/eorzo18pmJoAAAAS/cringe.gif")
    	    		.value("Cringe")
    	    		.post(postRepository.findById(1).get())
    	    		.user(userRepository.findById(10005).get()).build();
            
            Comment c6 = Comment.builder()
    	    		.dateCommented(LocalDate.now())
    	    		.media("https://media.tenor.com/PGVvHe1jMX8AAAAC/funny-laugh.gif")
    	    		.value("Benta! HAHAHAHA XD XD")
    	    		.post(postRepository.findById(8).get())
    	    		.user(userRepository.findById(10006).get()).build();
            
            Comment c7 = Comment.builder()
    	    		.dateCommented(LocalDate.now())
    	    		.media("https://japanpowered.com/media/images/cringe-baby-picture-800x450.jpg")
    	    		.value("ah ok")
    	    		.post(postRepository.findById(8).get())
    	    		.user(userRepository.findById(10008).get()).build();
            
            Comment c8 = Comment.builder()
    	    		.dateCommented(LocalDate.now())
    	    		.media("https://i.pinimg.com/736x/02/d8/c8/02d8c89ffe273e093d06036f49ed8302.jpg")
    	    		.value("hehe")
    	    		.post(postRepository.findById(8).get())
    	    		.user(userRepository.findById(10009).get()).build();
            
            Comment c9 = Comment.builder()
    	    		.dateCommented(LocalDate.now())
    	    		.media("https://www.incimages.com/uploaded_files/image/1920x1080/getty_627216922_2000149920009280228_336748.jpg")
    	    		.value("Ayos yan!")
    	    		.post(postRepository.findById(8).get())
    	    		.user(userRepository.findById(10007).get()).build();
            
            
            List<Comment> comment = List.of(c1, c2, c3, c4, c5, c6, c7, c8, c9);
            commentRepository.saveAll(comment);

        };
    }

}
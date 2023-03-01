package com.ssglobal.revalida.jibe.config;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ssglobal.revalida.jibe.model.Comment;
import com.ssglobal.revalida.jibe.model.Follow;
import com.ssglobal.revalida.jibe.model.Post;
import com.ssglobal.revalida.jibe.model.Role;
import com.ssglobal.revalida.jibe.model.User;
import com.ssglobal.revalida.jibe.repository.CommentRepository;
import com.ssglobal.revalida.jibe.repository.FollowRepository;
import com.ssglobal.revalida.jibe.repository.LikesRepository;
import com.ssglobal.revalida.jibe.repository.PostRepository;
import com.ssglobal.revalida.jibe.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class UsersConfig {
    private final PasswordEncoder passwordEncoder;
    @Bean
    CommandLineRunner commandLineRunnerUsers(UserRepository userRepository, PostRepository postRepository,
    		CommentRepository commentRepository, FollowRepository followRepository, LikesRepository likesRepository) {

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
                    .username("iceald")
                    .email("christian.alday@gmail.com")
                    .password(passwordEncoder.encode("Admin2255@"))
                    .bio("If I get takot, would you hawak me tight?\r\n"
                    		+ "If I gawa something mali, would you make it right?\r\n"
                    		+ "If I build an apoy, would you bantay the flame?\r\n"
                    		+ "If I sabi I miss you, would you ramdam the same?")
                    .imageUrl("https://media.discordapp.net/attachments/902067553210335237/902843224329191495/Sana-Ateneo.jpg?width=363&height=508")
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
                    .imageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Funny_Image_of_Dog_with_open_teeth.png/684px-Funny_Image_of_Dog_with_open_teeth.png?20220323025258")
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
                    .imageUrl("https://media.licdn.com/dms/image/C5603AQHZUAwOgcDPmw/profile-displayphoto-shrink_800_800/0/1643114548266?e=2147483647&v=beta&t=1a_IhmVEtppBkrFu5fzY7ZJ_DVFJT5z7YlhWgmFGJvc")
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
                    .imageUrl("https://media.licdn.com/dms/image/C5603AQHc3Va8eRsfiw/profile-displayphoto-shrink_800_800/0/1662706590359?e=2147483647&v=beta&t=-ajyOeGWp0LzdE36Q6LSzA7U1oYNUFdj6FAeXmpKeEw")
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
                    .imageUrl("https://dk2dv4ezy246u.cloudfront.net/widgets/sShYLWUqt40_large.jpg")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            
            List<User> users =List.of(user1,user2,user3,user4,user5,ice, jim, mars, nikki, jayann);

            userRepository.saveAll(users);


            Post p1 = Post.builder().body("Post Body 1")
            		.datePosted(LocalDateTime.now())
            		.imageUrl("https://cdn.britannica.com/36/123536-050-95CB0C6E/Variety-fruits-vegetables.jpg?w=400&h=300&c=crop")
            		.user(userRepository.findById(10000).get()).build();

            Post p2 = Post.builder().body("Post Body 2")
            		.datePosted(LocalDateTime.now())
            		.user(userRepository.findById(10000).get()).build();

            Post p3 = Post.builder().body("Post Body 3")
            		.datePosted(LocalDateTime.now().minusDays(1))
            		.imageUrl("picsum.photos/200")
            		.user(userRepository.findById(10001).get()).build();

            Post p4 = Post.builder().body("Post Body 4")
            		.datePosted(LocalDateTime.now().minusDays(1))
            		.imageUrl("picsum.photos/200")
            		.user(userRepository.findById(10002).get()).build();

            Post p5 = Post.builder().body("Post Body 5")
            		.datePosted(LocalDateTime.now().minusDays(2))
            		.imageUrl("picsum.photos/200")
            		.user(userRepository.findById(10002).get()).build();

            Post p6 = Post.builder().body("Post Body 6")
            		.datePosted(LocalDateTime.now().minusDays(2))
            		.imageUrl("picsum.photos/200")
            		.user(userRepository.findById(10003).get()).build();

            Post p7 = Post.builder().body("Post Body 7")
            		.datePosted(LocalDateTime.now().minusDays(5))
            		.imageUrl("picsum.photos/200")
            		.user(userRepository.findById(10004).get()).build();

            Post p8 = Post.builder().body("Dili nalang ako mag-talk")
            		.datePosted(LocalDateTime.now().minusDays(9))
            		.imageUrl("https://media.discordapp.net/attachments/902067553210335237/970647689144434738/sana-sana-twice.gif")
            		.user(userRepository.findById(10005).get()).build();

            Post p9= Post.builder().body("“Oo nga pala, hindi nga pala tayo”. "
            		+ "It’s the first line as the guitar lick settles in that sends an arrow straight to the heart– an honest, straightforward reminder of what you aren’t.")
            		.datePosted(LocalDateTime.now().minusDays(7))
            		.imageUrl("https://i.ytimg.com/vi/mV8_c6XKG34/maxresdefault.jpg")
            		.user(userRepository.findById(10006).get()).build();

            Post p10= Post.builder().body("LUH! Kulang ka sa lambing gago")
            		.datePosted(LocalDateTime.now().minusDays(2))
            		.imageUrl("bit.ly/3ZtJM4v")
            		.user(userRepository.findById(10007).get()).build();

            Post p11= Post.builder().body("Selfie sa sea. kAs1 Ang F3eL1n6xz Q 4 u n3vEr m0nG mA se S3e")
            		.datePosted(LocalDateTime.now().minusDays(5))
            		.imageUrl("bit.ly/3mdRhhC")
            		.user(userRepository.findById(10008).get()).build();

            Post p12= Post.builder().body("boom")
            		.datePosted(LocalDateTime.now().minusDays(1))
            		.imageUrl("https://i.pinimg.com/236x/d7/00/fa/d700fa0fbfd40a47d94ea1435c45d7d5.jpg")
            		.user(userRepository.findById(10009).get()).build();

            Post p13= Post.builder().body("Don't say you can't until you prove you can't. -Les Paul")
            		.datePosted(LocalDateTime.now().minusDays(4))
            		.user(userRepository.findById(10009).get()).build();

            Post p14= Post.builder().body("When in doubt, choose change.")
            		.datePosted(LocalDateTime.now().minusDays(7))
            		.user(userRepository.findById(10008).get()).build();
            
            Post p15= Post.builder().body("Give people a second change, but not third chance.")
            		.datePosted(LocalDateTime.now().minusDays(3))
            		.user(userRepository.findById(10005).get()).build();
            
            Post p16= Post.builder().body("Do not give up, the beginning is always the hardest.")
            		.datePosted(LocalDateTime.now().minusDays(2))
            		.user(userRepository.findById(10006).get()).build();
            
            Post p17 = Post.builder().body("Congratulations!")
					.datePosted(LocalDateTime.now().minusDays(15))
					.imageUrl("https://media.discordapp.net/attachments/902067553210335237/902843225931399178/Ryujin_UP.jpg?width=349&height=508")
					.user(userRepository.findById(10005).get()).build();
            
            List<Post> posts = List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10,
            		p11, p12, p13, p14, p15, p16, p17);
			
          
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
            
            Comment c10 = Comment.builder()
    	    		.dateCommented(LocalDate.now())
    	    		.value("Cheezzzyyy")
    	    		.post(postRepository.findById(9).get())
    	    		.user(userRepository.findById(10005).get()).build();
            
            Comment c11 = Comment.builder()
    	    		.dateCommented(LocalDate.now())
    	    		.value("Ayos yan idol!")
    	    		.post(postRepository.findById(9).get())
    	    		.user(userRepository.findById(10007).get()).build();
            
            Comment c12 = Comment.builder()
    	    		.dateCommented(LocalDate.now())
    	    		.value("Sadboi")
    	    		.post(postRepository.findById(9).get())
    	    		.user(userRepository.findById(10008).get()).build();
            
            Comment c13 = Comment.builder()
    	    		.dateCommented(LocalDate.now())
    	    		.media("https://media2.giphy.com/media/6pJNYBYSMFod2/giphy.gif")
    	    		.value("HAHAHAHA")
    	    		.post(postRepository.findById(9).get())
    	    		.user(userRepository.findById(10009).get()).build();
            
            Comment c14 = Comment.builder()
    	    		.dateCommented(LocalDate.now())
    	    		.value("Basta post ni idol like ko yan!")
    	    		.post(postRepository.findById(14).get())
    	    		.user(userRepository.findById(10006).get()).build();
            
            Comment c15 = Comment.builder()
    	    		.dateCommented(LocalDate.now())
    	    		.value("Gara ah!")
    	    		.post(postRepository.findById(14).get())
    	    		.user(userRepository.findById(10005).get()).build();
            
            Comment c16 = Comment.builder()
    	    		.dateCommented(LocalDate.now())
    	    		.media("https://icon-library.com/images/fb-like-icon/fb-like-icon-23.jpg")
    	    		.value("Tama yan!")
    	    		.post(postRepository.findById(16).get())
    	    		.user(userRepository.findById(10007).get()).build();
            
            List<Comment> comment = List.of(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10,
            		c11, c12, c13, c14, c15, c16);
            commentRepository.saveAll(comment);

             
        Follow f1 = Follow.builder()
        		.followee(userRepository.findById(10005).get())
        		.follower(userRepository.findById(10006).get()).build();
        
        Follow f2 = Follow.builder()
        		.followee(userRepository.findById(10005).get())
        		.follower(userRepository.findById(10007).get()).build();
        
        Follow f3 = Follow.builder()
        		.followee(userRepository.findById(10005).get())
        		.follower(userRepository.findById(10008).get()).build();
        
        Follow f4 = Follow.builder()
        		.followee(userRepository.findById(10005).get())
        		.follower(userRepository.findById(10009).get()).build();
        
        Follow f5 = Follow.builder()
        		.followee(userRepository.findById(10006).get())
        		.follower(userRepository.findById(10005).get()).build();
        
        Follow f6 = Follow.builder()
        		.followee(userRepository.findById(10006).get())
        		.follower(userRepository.findById(10007).get()).build();

        Follow f7 = Follow.builder()
        		.followee(userRepository.findById(10006).get())
        		.follower(userRepository.findById(10008).get()).build();

        
        Follow f8 = Follow.builder()
        		.followee(userRepository.findById(10006).get())
        		.follower(userRepository.findById(10009).get()).build();
        
        Follow f9 = Follow.builder()
        		.followee(userRepository.findById(10007).get())
        		.follower(userRepository.findById(10005).get()).build();

        Follow f10 = Follow.builder()
        		.followee(userRepository.findById(10007).get())
        		.follower(userRepository.findById(10006).get()).build();

        Follow f11 = Follow.builder()
        		.followee(userRepository.findById(10007).get())
        		.follower(userRepository.findById(10008).get()).build();

        Follow f12 = Follow.builder()
        		.followee(userRepository.findById(10007).get())
        		.follower(userRepository.findById(10009).get()).build();
        
        Follow f13 = Follow.builder()
        		.followee(userRepository.findById(10008).get())
        		.follower(userRepository.findById(10005).get()).build();
        
        Follow f14 = Follow.builder()
        		.followee(userRepository.findById(10008).get())
        		.follower(userRepository.findById(10006).get()).build();

        Follow f15 = Follow.builder()
        		.followee(userRepository.findById(10008).get())
        		.follower(userRepository.findById(10007).get()).build();

        Follow f16 = Follow.builder()
        		.followee(userRepository.findById(10008).get())
        		.follower(userRepository.findById(10009).get()).build();

        Follow f17 = Follow.builder()
        		.followee(userRepository.findById(10009).get())
        		.follower(userRepository.findById(10005).get()).build();

        Follow f18 = Follow.builder()
        		.followee(userRepository.findById(10009).get())
        		.follower(userRepository.findById(10006).get()).build();

        Follow f19 = Follow.builder()
        		.followee(userRepository.findById(10009).get())
        		.follower(userRepository.findById(10007).get()).build();

        Follow f20 = Follow.builder()
        		.followee(userRepository.findById(10009).get())
        		.follower(userRepository.findById(10008).get()).build();

        
        List<Follow> follow = List.of(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12,
        		f13, f14, f15, f16, f17, f18, f19, f20);
        followRepository.saveAll(follow);
      
       
        
        };
    }

}
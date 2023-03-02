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
import com.ssglobal.revalida.jibe.model.Likes;
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
                    .firstname("John Lloyd")
                    .lastname("Cruz")
                    .username("jlBiogesic")
                    .email("johnlloyd@gmail.com")
                    .password(passwordEncoder.encode("Biogesic111!"))
                    .bio("Award Winning Actor")
                    .birthday(LocalDate.now().minusDays(14496).toString())
                    .age(39)
                    .imageUrl("http://dummyimage.com/200x200.png/9933ff/ffffff")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            User user2 = User.builder()
                    .firstname("Bruno")
                    .lastname("Mars")
                    .username("BrunoMars")
                    .email("brunomars@gmail.com")
                    .password(passwordEncoder.encode("Bruno123@"))
                    .bio("Singer and Performer")
                    .birthday(LocalDate.now().minusDays(13659).toString())
                    .age(37)
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
                    .birthday(LocalDate.now().minusDays(14496).toString())
                    .age(39)
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
                    .birthday(LocalDate.now().minusDays(14496).toString())
                    .age(39)
                    .imageUrl("http://dummyimage.com/200x200.png/ff4133/ffffff")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            User user5 = User.builder()
                    .firstname("John")
                    .lastname("Doe")
                    .username("admin")
                    .email("admin@gmail.com")
                    .birthday(LocalDate.now().minusDays(14496).toString())
                    .age(39)
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
                    .bio("8-time Trip to Jerusalem Champion")
                    .birthday(LocalDate.now().minusDays(14496).toString())
                    .age(23)
                    .imageUrl("https://media.discordapp.net/attachments/902067553210335237/1080426738984689766/dp.jpg?width=515&height=508")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            
            User jim = User.builder()
                    .firstname("Jim Lloyd")
                    .lastname("De Guzman")
                    .username("jimlloyddg")
                    .email("jimlloyddeguzman60@gmail.com")
                    .password(passwordEncoder.encode("Jimlloyddg1@"))
                    .bio("Kung ayaw mong mainlove ng todo\r\n"
                    		+ "Ay huwag mo ng susubukang tingnan pa ako,\r\n"
                    		+ "dahil baka mabaliw ka ng husto!!\r\n"
                    		+ "")
                    .birthday(LocalDate.now().minusDays(8507).toString())
                    .age(23)
                    .imageUrl("https://thumbs.dreamstime.com/b/default-avatar-profile-vector-user-profile-default-avatar-profile-vector-user-profile-profile-179376714.jpg")
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
                    .birthday(LocalDate.now().minusDays(8563).toString())
                    .age(23)
                    .imageUrl("https://media.licdn.com/dms/image/C5603AQHZUAwOgcDPmw/profile-displayphoto-shrink_800_800/0/1643114548266?e=2147483647&v=beta&t=1a_IhmVEtppBkrFu5fzY7ZJ_DVFJT5z7YlhWgmFGJvc")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            
            User nikki = User.builder()
                    .firstname("Krishna Nicole")
                    .lastname("Fagara")
                    .username("Nikki143")
                    .email("krishnanicolefagara@gmail.com")
                    .password(passwordEncoder.encode("@dm1n2255"))
                    .bio("“In a relationship”\r\n"              		
                    		+ "Charr. Kinabahan yung may gusto sakin")
                    .birthday(LocalDate.now().minusDays(8320).toString())
                    .age(22)
                    .imageUrl("https://media.licdn.com/dms/image/C5603AQHc3Va8eRsfiw/profile-displayphoto-shrink_800_800/0/1662706590359?e=2147483647&v=beta&t=-ajyOeGWp0LzdE36Q6LSzA7U1oYNUFdj6FAeXmpKeEw")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            
            User jayann = User.builder()
                    .firstname("Jay-Ann")
                    .lastname("Oliveros")
                    .username("jayannisdname")
                    .email("jayann20oliveros@gmail.com")
                    .password(passwordEncoder.encode("2255Adm!n"))
                    .bio("Kahit anong suot mo, mas bagay parin ako sayo.")
                    .birthday(LocalDate.now().minusDays(8473).toString())
                    .age(23)
                    .imageUrl("https://dk2dv4ezy246u.cloudfront.net/widgets/sShYLWUqt40_large.jpg")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            
            User u6 = User.builder()
                    .firstname("Selena")
                    .lastname("Gomez")
                    .username("DSelena")
                    .email("selena@gmail.com")
                    .password(passwordEncoder.encode("adm!N2255"))
                    .bio("Kill them with kindness")
                    .birthday(LocalDate.now().minusDays(11180).toString())
                    .age(30)
                    .imageUrl("https://data1.ibtimes.co.in/en/full/698795/selena-gomez.png")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            
            User u7 = User.builder()
                    .firstname("Hailey")
                    .lastname("Bieber")
                    .username("ItsmeHailey")
                    .email("hbieber@gmail.com")
                    .password(passwordEncoder.encode("Adm!N2255"))
                    .bio("I might kill my boyfriend's ... ex")
                    .birthday(LocalDate.now().minusDays(9596).toString())
                    .age(26)
                    .imageUrl("https://guardian.ng/wp-content/uploads/2022/04/Hailey-Bieber.jpeg")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            
            User u8 = User.builder()
                    .firstname("Kylie")
                    .lastname("Jenner")
                    .username("kyliebaby")
                    .email("kylieJ@gmail.com")
                    .password(passwordEncoder.encode("kyL!e2255"))
                    .bio("I am your Kylie <3")
                    .birthday(LocalDate.now().minusDays(9335).toString())
                    .age(25)
                    .imageUrl("https://purneauniversity.org/wp-content/uploads/2022/11/Kylie-Jenner.png")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            
            User u9 = User.builder()
                    .firstname("Justin")
                    .lastname("Beiber")
                    .username("TheJustin")
                    .email("justinB@gmail.com")
                    .password(passwordEncoder.encode("JusT!n2255"))
                    .bio("Baby.. baby.. baby.. ohhh")
                    .birthday(LocalDate.now().minusDays(10593).toString())
                    .age(29)
                    .imageUrl("https://media.gq.com/photos/56bcb218cdf2db6945d2ef93/master/pass/bieber-coverstory-square.jpg")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            
            User u10 = User.builder()
                    .firstname("Kendall")
                    .lastname("Jenner")
                    .username("SimplyKendall")
                    .email("kendall@gmail.com")
                    .password(passwordEncoder.encode("Kend@all2255"))
                    .bio("Hi, This is Kendall.")
                    .birthday(LocalDate.now().minusDays(9981).toString())
                    .age(27)
                    .imageUrl("https://eldiariony.com/wp-content/uploads/sites/2/2022/03/GettyImages-1340155534-e1646784906210.jpg?quality=75&strip=all&w=1200")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            
            User u11 = User.builder()
                    .firstname("Liza")
                    .lastname("Soberano")
                    .username("lizaSoberano")
                    .email("lSoberano@gmail.com")
                    .password(passwordEncoder.encode("L!z@2255"))
                    .bio("Please, call me Hope.")
                    .birthday(LocalDate.now().minusDays(9188).toString())
                    .age(25)
                    .imageUrl("https://manilastandard.net/wp-content/uploads/2022/07/Liza-Soberano.jpg")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            
            User u12 = User.builder()
                    .firstname("Nadine")
                    .lastname("Lustre")
                    .username("nadinelustre")
                    .email("nadinelustre@gmail.com")
                    .password(passwordEncoder.encode("nAd!ne2255"))
                    .bio("Wait For Me.")
                    .birthday(LocalDate.now().minusDays(10714).toString())
                    .age(29)
                    .imageUrl("https://www.themoviedb.org/t/p/original/mRBOxYV5STAGIuqYVMo3OKd125K.jpg")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            
            User u13 = User.builder()
                    .firstname("James")
                    .lastname("Reid")
                    .username("jamesreid")
                    .email("jamesreid@gmail.com")
                    .password(passwordEncoder.encode("J@mesReid2255"))
                    .bio("Wait For Me.")
                    .birthday(LocalDate.now().minusDays(10887).toString())
                    .age(29)
                    .imageUrl("https://i.mydramalist.com/RlzvR_5f.jpg")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            
            User u14 = User.builder()
                    .firstname("Enrique")
                    .lastname("Gil")
                    .username("enrique")
                    .email("egil@gmail.com")
                    .password(passwordEncoder.encode("Enr!que2255"))
                    .bio("Hey, It's Quen.")
                    .birthday(LocalDate.now().minusDays(11294).toString())
                    .age(30)
                    .imageUrl("https://i.mydramalist.com/RlzvR_5f.jpg")
                    .firstTimeLogin(false)
                    .role(Role.USER)
                    .build();
            
            
            List<User> users =List.of(user1,user2,user3,user4,user5,ice, jim, mars, nikki, jayann,
            		u6, u7, u8, u9, u10, u11, u12, u13, u14);

            userRepository.saveAll(users);


            Post p1 = Post.builder().body("The way to get started is to quit talking and begin doing. -Walt Disney")
            		.datePosted(LocalDateTime.now())
            		.imageUrl("https://cdn.britannica.com/36/123536-050-95CB0C6E/Variety-fruits-vegetables.jpg?w=400&h=300&c=crop")
            		.user(userRepository.findById(10000).get()).build();

            Post p2 = Post.builder().body("FOR SALE: Kambing, P6,000 only! Meet up Biringan City")
            		.datePosted(LocalDateTime.now())
            		.imageUrl("https://m.media-amazon.com/images/I/91ave06oxzL.png")
            		.user(userRepository.findById(10000).get()).build();

            Post p3 = Post.builder().body("FOR SALE: iPhone 14 pro max, P9,000 only! With issue: Tumatawag ang may ari.")
            		.datePosted(LocalDateTime.now().minusDays(1))
            		.imageUrl("https://www.digitaltrends.com/wp-content/uploads/2022/09/iPhone-14-Pro-Back-Purple-Hand.jpg?p=1"  )
            		.user(userRepository.findById(10001).get()).build();

            Post p4 = Post.builder().body("FOR SALE: Banig upto 10 person. P200 only! Issue: Wala ng hihiga lahat nakatayo.")
            		.datePosted(LocalDateTime.now().minusDays(1))
            		.imageUrl("https://lh3.googleusercontent.com/-VlkyOaBwZNg/UmNl5Pdn3GI/AAAAAAAAGcg/ONDrlxQih2A/s800/banig.jpg")
            		.user(userRepository.findById(10002).get()).build();

            Post p5 = Post.builder().body("FOR SALE: Plantsa, P150 only! Issue: handle yung umiinit.")
            		.datePosted(LocalDateTime.now().minusDays(2))
            		.imageUrl("http://1.bp.blogspot.com/-13ILsS7vr3U/Ub2OJl0AMMI/AAAAAAAAIrU/lONVIMHD6iY/s1600/Plantsa1.jpg")
            		.user(userRepository.findById(10002).get()).build();

            Post p6 = Post.builder().body("FOR SALE: 2nd Hand Kaha de yero SUPER SECURED!, P180 only! Issue: Di ko mabuksan")
            		.datePosted(LocalDateTime.now().minusDays(2))
            		.imageUrl("https://media.karousell.com/media/photos/products/2021/4/11/antique_kaha_de_yero_1618106859_89493c42_progressive.jpg")
            		.user(userRepository.findById(10003).get()).build();

            Post p7 = Post.builder().body("Selena recently posted a now-deleted TikTok video admitting that she laminated her eyebrows \"too much.\" After this, Kylie posted a video on her Instagram Story showing off her eyebrows with the caption “this was an accident?????”.")
            		.datePosted(LocalDateTime.now().minusDays(5))
            		.imageUrl("https://media.distractify.com/brand-img/n67BDlYnc/2160x1130/selena-gomez-and-kylie-jenner-1677364172352.jpg")
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

            Post p10= Post.builder().body("LUH! Kulang ka sa lambing hehehe")
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

            Post p18 = Post.builder().body("Jealousy... is a mental cancer.")
                .datePosted(LocalDateTime.now().minusDays(10))
                .imageUrl("https://www.rollingstone.com/wp-content/uploads/2023/02/selena-gomez-album-teaser.jpg")
                .user(userRepository.findById(10010).get()).build();
            
            List<Post> posts = List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10,
            		p11, p12, p13, p14, p15, p16, p17, p18);
		      
            postRepository.saveAll(posts);
            
	        Comment c1 = Comment.builder()
		    		.dateCommented(LocalDateTime.now())
		    		.media("https://media.moddb.com/cache/images/members/5/4550/4549205/thumb_620x2000/duck.jpg")
		    		.value("This is banana.")
		    		.post(postRepository.findById(2).get())
		    		.user(userRepository.findById(10003).get()).build();
           
            Comment c2 = Comment.builder()
    	    		.dateCommented(LocalDateTime.now())
    	    		.media("https://pbs.twimg.com/profile_images/1074985128881864704/-WV56RC5_400x400.jpg")
    	    		.value("This is hatdog.")
    	    		.post(postRepository.findById(1).get())
    	    		.user(userRepository.findById(10001).get()).build();
            
            Comment c3 = Comment.builder()
    	    		.dateCommented(LocalDateTime.now())
    	    		.media("https://pbs.twimg.com/profile_images/653700295395016708/WjGTnKGQ_400x400.png")
    	    		.value("Wow nice banana.")
    	    		.post(postRepository.findById(2).get())
    	    		.user(userRepository.findById(10002).get()).build();
            
            Comment c4 = Comment.builder()
    	    		.dateCommented(LocalDateTime.now())
    	    		.media("https://media.tenor.com/9ModG8XWV5AAAAAd/puss-in.gif")
    	    		.value("Can you dm me this photo?")
    	    		.post(postRepository.findById(2).get())
    	    		.user(userRepository.findById(10004).get()).build();
            
            Comment c5 = Comment.builder()
    	    		.dateCommented(LocalDateTime.now())
    	    		.media("https://media.tenor.com/eorzo18pmJoAAAAS/cringe.gif")
    	    		.value("Cringe")
    	    		.post(postRepository.findById(1).get())
    	    		.user(userRepository.findById(10005).get()).build();
            
            Comment c6 = Comment.builder()
    	    		.dateCommented(LocalDateTime.now())
    	    		.media("https://media.tenor.com/PGVvHe1jMX8AAAAC/funny-laugh.gif")
    	    		.value("Benta! HAHAHAHA XD XD")
    	    		.post(postRepository.findById(8).get())
    	    		.user(userRepository.findById(10006).get()).build();
            
            Comment c7 = Comment.builder()
    	    		.dateCommented(LocalDateTime.now())
    	    		.media("https://japanpowered.com/media/images/cringe-baby-picture-800x450.jpg")
    	    		.value("ah ok")
    	    		.post(postRepository.findById(8).get())
    	    		.user(userRepository.findById(10008).get()).build();
            
            Comment c8 = Comment.builder()
    	    		.dateCommented(LocalDateTime.now())
    	    		.media("https://i.pinimg.com/736x/02/d8/c8/02d8c89ffe273e093d06036f49ed8302.jpg")
    	    		.value("hehe")
    	    		.post(postRepository.findById(8).get())
    	    		.user(userRepository.findById(10009).get()).build();
            
            Comment c9 = Comment.builder()
    	    		.dateCommented(LocalDateTime.now())
    	    		.media("https://www.incimages.com/uploaded_files/image/1920x1080/getty_627216922_2000149920009280228_336748.jpg")
    	    		.value("Ayos yan!")
    	    		.post(postRepository.findById(8).get())
    	    		.user(userRepository.findById(10007).get()).build();
            
            Comment c10 = Comment.builder()
    	    		.dateCommented(LocalDateTime.now())
    	    		.value("Cheezzzyyy")
    	    		.post(postRepository.findById(9).get())
    	    		.user(userRepository.findById(10005).get()).build();
            
            Comment c11 = Comment.builder()
    	    		.dateCommented(LocalDateTime.now())
    	    		.value("Ayos yan idol!")
    	    		.post(postRepository.findById(9).get())
    	    		.user(userRepository.findById(10007).get()).build();
            
            Comment c12 = Comment.builder()
    	    		.dateCommented(LocalDateTime.now())
    	    		.value("Sadboi")
    	    		.post(postRepository.findById(9).get())
    	    		.user(userRepository.findById(10008).get()).build();
            
            Comment c13 = Comment.builder()
    	    		.dateCommented(LocalDateTime.now())
    	    		.media("https://media2.giphy.com/media/6pJNYBYSMFod2/giphy.gif")
    	    		.value("HAHAHAHA")
    	    		.post(postRepository.findById(9).get())
    	    		.user(userRepository.findById(10009).get()).build();
            
            Comment c14 = Comment.builder()
    	    		.dateCommented(LocalDateTime.now())
    	    		.value("Basta post ni idol like ko yan!")
    	    		.post(postRepository.findById(14).get())
    	    		.user(userRepository.findById(10006).get()).build();
            
            Comment c15 = Comment.builder()
    	    		.dateCommented(LocalDateTime.now())
    	    		.value("Gara ah!")
    	    		.post(postRepository.findById(14).get())
    	    		.user(userRepository.findById(10005).get()).build();
            
            Comment c16 = Comment.builder()
    	    		.dateCommented(LocalDateTime.now())
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
        
        Follow f21 = Follow.builder()
        		.followee(userRepository.findById(10010).get())
        		.follower(userRepository.findById(10000).get()).build();
        
        Follow f22 = Follow.builder()
        		.followee(userRepository.findById(10010).get())
        		.follower(userRepository.findById(10001).get()).build();
        
        Follow f23 = Follow.builder()
        		.followee(userRepository.findById(10010).get())
        		.follower(userRepository.findById(10002).get()).build();
        
        Follow f24 = Follow.builder()
        		.followee(userRepository.findById(10010).get())
        		.follower(userRepository.findById(10003).get()).build();
        
        Follow f25 = Follow.builder()
        		.followee(userRepository.findById(10010).get())
        		.follower(userRepository.findById(10004).get()).build();
        
        Follow f26 = Follow.builder()
        		.followee(userRepository.findById(10010).get())
        		.follower(userRepository.findById(10005).get()).build();
        
        Follow f27 = Follow.builder()
        		.followee(userRepository.findById(10010).get())
        		.follower(userRepository.findById(10006).get()).build();
        
        Follow f28 = Follow.builder()
        		.followee(userRepository.findById(10010).get())
        		.follower(userRepository.findById(10007).get()).build();
        
        Follow f29 = Follow.builder()
        		.followee(userRepository.findById(10010).get())
        		.follower(userRepository.findById(10008).get()).build();
        
        Follow f30 = Follow.builder()
        		.followee(userRepository.findById(10010).get())
        		.follower(userRepository.findById(10009).get()).build();
        
        List<Follow> follow = List.of(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12,
        		f13, f14, f15, f16, f17, f18, f19, f20, f21, f22,
        		f23, f24, f25, f26, f27, f28, f29, f30);
        followRepository.saveAll(follow);
      
        Likes l1 = Likes.builder()
        		.userID(10000)
        		.postID(18).build();
        
        Likes l2 = Likes.builder()
        		.userID(10001)
        		.postID(18).build();
        
        Likes l3 = Likes.builder()
        		.userID(10002)
        		.postID(18).build();
        
        Likes l4 = Likes.builder()
        		.userID(10003)
        		.postID(18).build();
        
        Likes l5 = Likes.builder()
        		.userID(10004)
        		.postID(18).build();
        
        Likes l6 = Likes.builder()
        		.userID(10005)
        		.postID(18).build();
        
        Likes l7 = Likes.builder()
        		.userID(10006)
        		.postID(18).build();
        
        Likes l8 = Likes.builder()
        		.userID(10007)
        		.postID(18).build();
        
        Likes l9 = Likes.builder()
        		.userID(10008)
        		.postID(18).build();
        
        Likes l10 = Likes.builder()
        		.userID(10009)
        		.postID(18).build();
       
        List<Likes> likes = List.of(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10);
        likesRepository.saveAll(likes);
        
        };
    }
}
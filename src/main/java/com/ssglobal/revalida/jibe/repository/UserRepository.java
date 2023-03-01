package com.ssglobal.revalida.jibe.repository;

import com.ssglobal.revalida.jibe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByFollowedBys_Follower_Username(String username);
    List<User> findByFollows_Follower_Username(String username);
    @Query("select u from User u inner join u.followedBys followedBys where u.id <> ?1 and followedBys.follower.id <> ?1 order by random() limit ?2")
    List<User> findByIdNotAndFollowedBys_Follower_IdNot(Integer id,Integer count);

    @Query(nativeQuery = true,value ="select * from _user u where u.id != ?1 order by random() limit ?2")
    List<User> findByIdNot(Integer id, Integer count);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
    List<User> findByUsernameLikeIgnoreCase(String username);
    Optional<User> findByEmail(String email);

//    @Override
//    Optional<User> findById(Integer integer);
//    List<User> findByUsernameLikeIgnoreCase(String username);
//
//    boolean existsByEmail(String email);
//    boolean existsByUsername(String username);
//    Optional<User> findByUsername(String username);
//
//    Optional<User> findByEmail(String email);
}
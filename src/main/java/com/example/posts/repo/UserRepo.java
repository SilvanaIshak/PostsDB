package com.example.posts.repo;

import com.example.posts.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {

    List<User> findAll();

    @Query(value = "select * from user where id IN (select id_user from post group by id_user having count(id_user) >1)", nativeQuery = true)
    public List<User> UserPosts();


    @Query(value = "select u from User u where u.posts.size > :count")
    public List<User> UserPostsCount(int count);
}

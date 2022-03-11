package com.nicolasjoaquinparisi.socialmedia.repository;

import com.nicolasjoaquinparisi.socialmedia.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("" +
            "SELECT COUNT(*) > 0 " +
            "FROM User u " +
            "WHERE u.username = :username")
    Boolean selectExistsUsername(@Param("username") String username);
}

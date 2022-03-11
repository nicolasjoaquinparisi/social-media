package com.nicolasjoaquinparisi.socialmedia.repository;

import com.nicolasjoaquinparisi.socialmedia.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}

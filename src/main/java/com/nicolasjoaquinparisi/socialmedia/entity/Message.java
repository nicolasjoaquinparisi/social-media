package com.nicolasjoaquinparisi.socialmedia.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Table(name = "Message",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = {"creation_date"})})
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "creation_date")
    private LocalDateTime date;

    @NotBlank(message = "The message's content can't be empty")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_sender_id")
    private User userSender;

    @ManyToOne
    @JoinColumn(name = "user_receiver_id")
    private User userReceiver;

    public Message(@JsonProperty("date") LocalDateTime date,
                   @JsonProperty("content") String content) {
        this.date = date;
        this.content = content;
    }

}
package com.nicolasjoaquinparisi.socialmedia.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "User")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Username can't be blank")
    private String username;

    @Length(message = "Password must contain at least 6 characters", min = 6)
    @NotBlank(message = "The password can't be blank")
    private String password;

    @NotBlank(message = "The name of the user can't be blank")
    private String name;

    @NotBlank(message = "The lastname of the user can't be blank")
    private String lastname;

    @OneToMany(mappedBy = "userSender")
    private List<Message> messagesSent = new ArrayList<Message>();

    public User(@JsonProperty("username") String username,
                @JsonProperty("password") String password,
                @JsonProperty("name") String name,
                @JsonProperty("lastname") String lastname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
    }
}

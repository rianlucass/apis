package com.rianlucas.security.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "tweets")
@Getter
@Setter
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private User user;
    private String content;

    @CreationTimestamp
    private Instant creationTimeStamp;

}

package com.timeline.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;

    private String content;

    private String writer;

    @Builder
    public Post(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

}

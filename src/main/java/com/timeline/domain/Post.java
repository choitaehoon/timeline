package com.timeline.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;

    private String content;

    @Builder
    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

}

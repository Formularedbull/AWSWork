package com.mega.it.springboot.domain.posts;

import com.mega.it.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // public Posts(){} 생성 -> 기본 생성자 생성
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition =  "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 빌더 패턴(디자인 패턴) Getter Setter 대신 더 편한게 쓰기 위해 클래스 안에 클래스를 생성
    public Posts(String title, String content, String author){
        this.title = title;
        this.content =content;
        this.author = author;
    }
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}

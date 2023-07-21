package com.mega.it.springboot.domain.posts;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest extends TestCase {
    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll(); //실행 후 @After 이니까 실행이 되서 cleanup 으로 deleteAll 해서 모두 삭제 시키는 기능
    }
    @Test
    public void 게시물저장_불러오기(){
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder().title(title).content(content).author("abc@gmail.com").build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {
        LocalDateTime now = LocalDateTime.of(2002,10,03,0,0,0);
        postsRepository.save(Posts.builder().title("title").content("content").author("author").build());
        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        System.out.println(">>>>>>>> createDate="+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());

        assertThat(posts.getCreatedDate().isAfter(now));
        assertThat(posts.getModifiedDate().isAfter(now));
    }
}
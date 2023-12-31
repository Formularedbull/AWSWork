package com.mega.it.springboot.web;

import com.mega.it.springboot.config.auth.LoginUser;
import com.mega.it.springboot.config.auth.dto.SessionUser;
import com.mega.it.springboot.service.posts.PostsService;
import com.mega.it.springboot.web.dto.PostsListResponseDto;
import com.mega.it.springboot.web.dto.PostsResponseDto;
import com.mega.it.springboot.web.dto.PostsSaveRequestDto;
import com.mega.it.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
    @GetMapping(value = "/")
        public String index(Model model, @LoginUser SessionUser user) {
            model.addAttribute("posts", postsService.findAllDesc());

        if(user != null){
            model.addAttribute("userName1", user.getName());
        }
            return "index";
    }
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
}
    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}

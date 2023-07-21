package com.mega.it.springboot.web;

import com.mega.it.springboot.service.posts.PostsService;
import com.mega.it.springboot.web.dto.PostsListResponseDto;
import com.mega.it.springboot.web.dto.PostsSaveRequestDto;
import com.mega.it.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    @GetMapping(value = "/")
        public String index(Model model) {
            model.addAttribute("posts", postsService.findAllDesc());
            return "index";
    }
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}

package com.socialmedia.controller;

import com.socialmedia.model.Post;
import com.socialmedia.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@CrossOrigin("*")
public class PostController {

    @Autowired
    private PostRepository postRepository;


    // CREATE POST

    @PostMapping
    public Post createPost(
            @RequestBody Post post
    ) {

        return postRepository.save(post);
    }


    // GET POSTS

    @GetMapping
    public List<Post> getPosts() {

        return postRepository.findAll();
    }


    // UPVOTE

    @PostMapping("/{id}/upvote")
    public String upvote(
            @PathVariable Long id
    ) {

        Post post =
                postRepository.findById(id)
                        .orElseThrow();

        post.setVotes(
                post.getVotes() + 1
        );

        postRepository.save(post);

        return "Upvoted";
    }


    // DOWNVOTE

    @PostMapping("/{id}/downvote")
    public String downvote(
            @PathVariable Long id
    ) {

        Post post =
                postRepository.findById(id)
                        .orElseThrow();

        post.setVotes(
                post.getVotes() - 1
        );

        postRepository.save(post);

        return "Downvoted";
    }
}
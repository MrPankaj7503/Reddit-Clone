package com.socialmedia.controller;

import com.socialmedia.model.Comment;
import com.socialmedia.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin("*")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;


    // ADD COMMENT

    @PostMapping
    public Comment addComment(
            @RequestBody Comment comment
    ) {

        return commentRepository.save(comment);
    }


    // GET COMMENTS

    @GetMapping
    public List<Comment> getComments() {

        return commentRepository.findAll();
    }
}
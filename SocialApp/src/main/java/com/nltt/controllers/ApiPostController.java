/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nltt.controllers;

import com.nltt.pojo.Comments;
import com.nltt.pojo.PostPhoto;
import com.nltt.pojo.Posts;
import com.nltt.service.CommentService;
import com.nltt.service.PhotoService;
import com.nltt.service.PostService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author tadai
 */
@RestController
@RequestMapping("/api")
public class ApiPostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService cmtService;
    
    @Autowired
    private PhotoService photoService;

    @RequestMapping("/posts/")
    @CrossOrigin
    public ResponseEntity<List<Posts>> listPosts() {
        return new ResponseEntity<>(this.postService.getPosts(), HttpStatus.OK);
    }

    @PostMapping(path = "/add-post/", consumes = {
        MediaType.MULTIPART_FORM_DATA_VALUE,
        MediaType.APPLICATION_JSON_VALUE
    })
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public void add(@RequestParam Map<String, String> params, @RequestPart(required = false) MultipartFile[] files) {
        Posts p = new Posts();
        p.setContent(params.get("content"));
        this.postService.addOrEditPost(p);
        if(files !=null){
          this.photoService.addPhoto(p, files);
        }
    }

    @DeleteMapping("/posts/{postID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CrossOrigin
    public void delete(@PathVariable(value = "postID") int id) {
        this.postService.deletePost(id);
    }

    @GetMapping("/posts/{postID}/comments/")
    @CrossOrigin
    public ResponseEntity<List<Comments>> listComments(@PathVariable(value = "postID") int id) {
        return new ResponseEntity<>(this.cmtService.getComments(id), HttpStatus.OK);
    }
    
    @GetMapping("/posts/{postID}/photos/")
    @CrossOrigin
    public ResponseEntity<List<PostPhoto>> listPhotosByPost(@PathVariable(value = "postID") int postId){
        return new ResponseEntity<>(this.photoService.getPhotoByPostId(postId) , HttpStatus.OK);
    }
    
    @GetMapping("posts/photos/")
    @CrossOrigin
    public ResponseEntity<List<PostPhoto>> listPhotos(){
        return new ResponseEntity<>(this.photoService.getPhotos() , HttpStatus.OK);
    }
    
    @PostMapping(path="/comments/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Comments> addComment(@RequestBody Comments comment) {
        Comments c = this.cmtService.addComment(comment);
        
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
    
    @GetMapping("/{userID}/posts/")
    @CrossOrigin
     public ResponseEntity<List<Posts>> listPostsByUser(@PathVariable(value = "userID") int id){
        return new ResponseEntity<>(this.postService.getPostsByUser(id) , HttpStatus.OK);
    }
}

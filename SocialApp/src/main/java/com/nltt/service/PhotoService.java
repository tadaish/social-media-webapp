/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nltt.service;

import com.nltt.pojo.PostPhoto;
import com.nltt.pojo.Posts;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author tadai
 */
public interface PhotoService {
    List<PostPhoto> getPhotoByPostId(int postId);
    List<PostPhoto> getPhotos();
    void addPhoto(Posts p, MultipartFile[] files);
}

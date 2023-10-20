/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nltt.repository;

import com.nltt.pojo.PostPhoto;
import java.util.List;

/**
 *
 * @author tadai
 */
public interface PhotoRepository {
    List<PostPhoto> getPhotoByPostId(int postId);
    PostPhoto addPhoto(PostPhoto photo);
    List<PostPhoto> getPhotos();
}

package com.nltt.pojo;

import com.nltt.pojo.Posts;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-10T23:46:57")
@StaticMetamodel(PostPhoto.class)
public class PostPhoto_ { 

    public static volatile SingularAttribute<PostPhoto, String> photo;
    public static volatile SingularAttribute<PostPhoto, Integer> id;
    public static volatile SingularAttribute<PostPhoto, Posts> postId;

}
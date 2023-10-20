package com.nltt.pojo;

import com.nltt.pojo.Comments;
import com.nltt.pojo.PostPhoto;
import com.nltt.pojo.Reactions;
import com.nltt.pojo.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-10T23:46:57")
@StaticMetamodel(Posts.class)
public class Posts_ { 

    public static volatile SetAttribute<Posts, Comments> commentsSet;
    public static volatile SetAttribute<Posts, PostPhoto> postPhotoSet;
    public static volatile SingularAttribute<Posts, Date> postDate;
    public static volatile SingularAttribute<Posts, Integer> postID;
    public static volatile SingularAttribute<Posts, String> media;
    public static volatile SetAttribute<Posts, Reactions> reactionsSet;
    public static volatile SingularAttribute<Posts, Users> userID;
    public static volatile SingularAttribute<Posts, String> content;

}
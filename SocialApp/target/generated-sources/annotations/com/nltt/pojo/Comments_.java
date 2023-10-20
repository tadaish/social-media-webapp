package com.nltt.pojo;

import com.nltt.pojo.Posts;
import com.nltt.pojo.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-10T23:46:57")
@StaticMetamodel(Comments.class)
public class Comments_ { 

    public static volatile SingularAttribute<Comments, Integer> commentID;
    public static volatile SingularAttribute<Comments, Posts> postID;
    public static volatile SingularAttribute<Comments, Users> userID;
    public static volatile SingularAttribute<Comments, String> content;
    public static volatile SingularAttribute<Comments, Date> timestamp;

}
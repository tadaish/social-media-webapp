package com.nltt.pojo;

import com.nltt.pojo.Comments;
import com.nltt.pojo.Posts;
import com.nltt.pojo.Reactions;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-10T23:46:57")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SetAttribute<Users, Comments> commentsSet;
    public static volatile SingularAttribute<Users, String> role;
    public static volatile SetAttribute<Users, Posts> postsSet;
    public static volatile SingularAttribute<Users, String> gender;
    public static volatile SingularAttribute<Users, String> about;
    public static volatile SingularAttribute<Users, String> avatar;
    public static volatile SingularAttribute<Users, Integer> userID;
    public static volatile SingularAttribute<Users, Integer> studentID;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, Date> createdDate;
    public static volatile SingularAttribute<Users, String> coverImage;
    public static volatile SingularAttribute<Users, String> fullname;
    public static volatile SetAttribute<Users, Reactions> reactionsSet;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> username;

}
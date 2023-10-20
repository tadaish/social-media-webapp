package com.nltt.pojo;

import com.nltt.pojo.Posts;
import com.nltt.pojo.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-10T23:46:57")
@StaticMetamodel(Reactions.class)
public class Reactions_ { 

    public static volatile SingularAttribute<Reactions, Integer> reactionID;
    public static volatile SingularAttribute<Reactions, Posts> postID;
    public static volatile SingularAttribute<Reactions, Users> userID;

}
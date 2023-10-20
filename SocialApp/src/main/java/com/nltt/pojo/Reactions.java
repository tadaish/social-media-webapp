/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nltt.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tadai
 */
@Entity
@Table(name = "reactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reactions.findAll", query = "SELECT r FROM Reactions r"),
    @NamedQuery(name = "Reactions.findByReactionID", query = "SELECT r FROM Reactions r WHERE r.reactionID = :reactionID")})
public class Reactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ReactionID")
    private Integer reactionID;
    @JoinColumn(name = "PostID", referencedColumnName = "PostID")
    @ManyToOne(optional = false)
    private Posts postID;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private Users userID;

    public Reactions() {
    }

    public Reactions(Integer reactionID) {
        this.reactionID = reactionID;
    }

    public Integer getReactionID() {
        return reactionID;
    }

    public void setReactionID(Integer reactionID) {
        this.reactionID = reactionID;
    }

    public Posts getPostID() {
        return postID;
    }

    public void setPostID(Posts postID) {
        this.postID = postID;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reactionID != null ? reactionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reactions)) {
            return false;
        }
        Reactions other = (Reactions) object;
        if ((this.reactionID == null && other.reactionID != null) || (this.reactionID != null && !this.reactionID.equals(other.reactionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nltt.pojo.Reactions[ reactionID=" + reactionID + " ]";
    }
    
}

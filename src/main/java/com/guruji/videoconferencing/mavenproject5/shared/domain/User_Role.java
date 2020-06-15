/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guruji.videoconferencing.mavenproject5.shared.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author dell
 */

@Entity
@Table(name="user_role1")
public class User_Role implements Serializable 
{

   
    
    public User_Role()
    {
    
    }
    
  
    
        @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer user_role_id;
        
        @Column(name="TYPE", length=15, unique=true, nullable=false)
	private String type = UserProfileType.Registered_User.getUserProfileType();

    public Integer getUser_role_id() 
    {
        return user_role_id;
    }

    public void setUser_role_id(int user_role_id) 
    {
        this.user_role_id = user_role_id;
    }

    public String getType() 
    {
        return type;
    }

    public void setType(String type) 
    {
        this.type = type;
    }
    
    @Override
	public int hashCode() 
        {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_role_id == null) ? 0 : user_role_id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
                    return true;
                }
		if (obj == null) {
                    return false;
                }
		if (!(obj instanceof User_Role)) {
                    return false;
                }
		User_Role other = (User_Role) obj;
		if (user_role_id == null) 
                {
			if (other.user_role_id != null)
                        {
				return false;
                        }
		}
                else if (!user_role_id.equals(other.user_role_id))
                {
			return false;
                }
		if (type == null)
                {
			if (other.type != null)
                        {
				return false;
                        }
		}
                else if (!type.equals(other.type))
                {
			return false;
                }
		return true;
	}
    
    

    @Override
    public String toString()
    {
        return "User_Role{" + "user_role_id=" + user_role_id + ", type=" + type + '}';
    }

    
         
        
        
        
    
    
    
    
    
}

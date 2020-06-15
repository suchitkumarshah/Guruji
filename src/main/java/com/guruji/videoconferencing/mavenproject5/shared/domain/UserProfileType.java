/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guruji.videoconferencing.mavenproject5.shared.domain;

import java.io.Serializable;

/**
 *
 * @author dell
 */
public enum UserProfileType implements Serializable
{
	
        Registered_User("Registered_User"),
	DBA("DBA"),
	Admin("Admin");
	
	private String userProfileType;
	
	private UserProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}

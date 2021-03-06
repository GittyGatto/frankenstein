package com.henning.frankenstein.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class User
{
	public final String userName;
	@JsonIgnore
	public final String password;
	public final Role role;

	public User(String userName, String password, Role role)
	{
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public User(UserEntity userEntity)
	{
		this(userEntity.getUserName(), userEntity.getPassword(), userEntity.getRole());
	}
}

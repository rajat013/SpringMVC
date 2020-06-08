package com.stackroute.myapp.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.myapp.model.UserProfile;

public class UserRepo {

	@Autowired
	UserProfile user;
	
	public UserProfile getUser() {
		return user;
	}

	public void setUser(UserProfile user) {
		this.user = user;
	}

	List<UserProfile> users;
	

	public UserProfile getUserbyName(String name)
	{
		//return users.stream().filter( u -> u.getUsername().equals(name) ).findAny().get();
		
		 ListIterator<UserProfile> iterate=users.listIterator();
		   UserProfile user=null;
		  
		 while(iterate.hasNext())
		 {
			   user=iterate.next();
			 
			 if(user.getUsername().equals(name))
			 {
				return user;
			 }
			 
			 
		 }
		 
		 return user;
		 
		
		
		
	}
	
	public List<UserProfile> getUsers() {
		return users;
	}

	public boolean addUser(UserProfile user)
	{
		
		users.add(user);
		return true;
	}
	
	public boolean deleteUser(String name)
	{
	 ListIterator<UserProfile> iterate=users.listIterator();
	 
	 while(iterate.hasNext())
	 {
		 UserProfile user=iterate.next();
		 
		 if(user.getUsername().equals(name))
		 {
			 iterate.remove();
		 }
		 
		 
	 }
	 
	 return true;
	 
	}
	
	
	public boolean update(String uname)
	{
		UserProfile usertoUpdate=getUserbyName(uname);
		
		
		return true;
	}
	public void setUsers(List<UserProfile> users) {
		this.users = users;
	}

	UserRepo()
	{
		users=new ArrayList();
	}
	
	
	
	
	
	
}

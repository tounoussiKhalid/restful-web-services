package com.india.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService 
{
	private static List<User> users = new ArrayList<>();
	
	private static int userCount = 0;
	
	static {
		users.add( new User(++userCount, "khalid", new Date()));
		users.add( new User(++userCount, "Youness", new Date()));
		users.add( new User(++userCount, "Mohamed", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save( User user)
	{
		if ( user.getId() == null)
		{
			user.setId(++userCount);
		}	
		users.add( user);
		return user;
	}
	
	public User findOne( int id)
	{
		for (User user : users ) {
			if ( user.getId().equals(id))
				return user;
		}
		return null;
	}
	
	public User deleteById( int id)
	{
		Iterator<User> iterator = users.iterator();
		while ( iterator.hasNext() )
		{
			User user = iterator.next();
			if ( user.getId().equals(id))
			{
				iterator.remove();
				return user;
			}
		}
		
		return null;
	}
	
	
}

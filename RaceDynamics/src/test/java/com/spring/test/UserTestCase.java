package com.spring.test;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import com.spring.dao.UserDAO;
import com.spring.model.Users;

@ComponentScan("com.spring")
public class UserTestCase {
	
/*	@Autowired
	private static Users user;
	*/

	@Autowired
	private static UserDAO userDAO;
	static Users users;
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.spring.*");
		context.refresh();
		
		users=(Users) context.getBean("users");
		userDAO=(UserDAO) context.getBean("userDAO");
	
	}
	
	@Test
	public void createProduct()
	{
	 users=new Users();
	users.setFirstname("piyush");
	users.setLastname("sharma");
	users.setUsername("piyush");
		
		boolean flag=userDAO.saveUser(users);
		
		assertEquals("User craeted", true, flag);
		
		
	}
}
	
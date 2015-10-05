package com.journaldev.spring.jdbc.main;

import java.util.List;
import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.journaldev.spring.jdbc.dao.ContactDAO;
import com.journaldev.spring.jdbc.dao.EmployeeDAO;
import com.journaldev.spring.jdbc.model.Contact;
import com.journaldev.spring.jdbc.model.Employee;

public class SpringMain {

	public static void main(String[] args) {
		//Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		//Get the EmployeeDAO Bean
		//EmployeeDAO employeeDAO = ctx.getBean("employeeDAO", EmployeeDAO.class);
		//To use JdbcTemplate
		ContactDAO contactDAO = ctx.getBean("contactDAOTemplate", ContactDAO.class);
		
		//Run some tests for JDBC CRUD operations
		/*Employee emp = new Employee();
		int rand = new Random().nextInt(1000);
		emp.setId(rand);
		emp.setName("Pankaj");
		emp.setRole("Java Developer");*/
		
		Contact cnt = new Contact();
		int rand1 = new Random().nextInt(1000);
		cnt.setId(rand1);
		cnt.setName("sana");
		cnt.setEmail("email@test.com");
		cnt.setAddress("address");
		cnt.setTelephone("5682 890");
		
		//Create
		//employeeDAO.save(emp);
		
		contactDAO.saveOrUpdate(cnt);
		
		//Read
		//Employee emp1 = employeeDAO.getById(rand);
		//System.out.println("Employee Retrieved::"+emp1);
		
		//Update
		//emp.setRole("CEO");
	//	employeeDAO.update(emp);
		
		//Get All
		//List<Employee> empList = employeeDAO.getAll();
		//System.out.println(empList);
	
		//Delete
		//employeeDAO.deleteById(rand);
		
		//Close Spring Context
		ctx.close();
		
		System.out.println("DONE");
	}

}

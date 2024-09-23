package com.example.demo;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.DAOLayer.DaoMethods;
import com.example.Entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@SpringBootApplication
@EntityScan("com.example.Entity")
@ComponentScan(basePackages = {"com.example"})
public class JpaPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaPracticeApplication.class, args);
		
	}
	@Bean
	CommandLineRunner commandLineRunner(DaoMethods daoMethods, EntityManager entityManager) {
		return runner->{
			onCall(daoMethods);
			//createNew(daoMethods);
			//read(1,daoMethods);
			readAll(entityManager);
			//update(daoMethods,2);
		//deleteById(daoMethods, 2);
		};
		
	}
	void onCall(DaoMethods daoMethods) {
		Student s1=new Student("Reetesh", "Patel", "Patel@user1");
		Student s2=new Student("Raj", "Patel", "Raj@user2");
		Student s3=new Student("Ankit", "Patel", "PatelAnkit@user3");
		Student s4=new Student("Ram", "Patel", "ram@user4");
		Student s5=new Student("Chandra", "Patel", "chandra@user5");
		Student s6=new Student("RSP", "Patel", "PatelRSP@user6");
		daoMethods.create(s1);
		daoMethods.create(s2);
		daoMethods.create(s3);
		daoMethods.create(s4);
		daoMethods.create(s5);
		daoMethods.create(s6);
		
	}
	private void deleteById(DaoMethods daoMethods, int i) {
		//calling the delete method from the service layer
		System.out.println(daoMethods.delete(i));	
	}
	//Updating the paticular entity in the database
	
	private void update(DaoMethods daoMethods, int i) {
		// Fetching the object from the Database
		Student s=daoMethods.read(i);
		// Setting the updated feilds
		s.setFname("Abhay");
		// saving it in the database
		daoMethods.update(s);
		System.out.println(s);
		
	}
	
	// Retrieving multiple objects using JPA query language
	private void readAll(EntityManager entityManager) {
		//creating the typed query  Using Entity class
		TypedQuery<Student> query=entityManager.createQuery("from Student",Student.class );
		// Getting the resultlist using typedQuery object
		ArrayList<Student> list=(ArrayList<Student>) query.getResultList();
		// Dispalying the  returned list
		System.out.println(list);
	}
	//reading the object from the database
	private void read(int id, DaoMethods daoMethods) {
		//fetch the object from the Database
		Student s=daoMethods.read(id);
		// dispaly the object
		System.out.println(s);
	}
	
	
	//creating a new object
	private void createNew(DaoMethods daoMethods) {
		// create the new student object
		Student s1=new Student("Akash", "Nema", "Akash@user");
		// save the student object
		daoMethods.create(s1);
		//Displaying the newly created object
		System.out.println(s1);
	}	
}

package com.example.jpa;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa.model.Gender;
import com.example.jpa.model.User;
import com.example.jpa.model.UserProfile;
import com.example.jpa.repository.UserProfileRepository;
import com.example.jpa.repository.UserRepository;

@SpringBootApplication
public class JpaOneToOneDemoApplication implements CommandLineRunner
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaOneToOneDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		//clean up database table
		
		userProfileRepository.deleteAllInBatch();
		userRepository.deleteAllInBatch();
		
		//=========================================
		
		//create a User instance
		User user = new User("Krunal", "Redkar", 
				"krunalredkar@gmail.com", "MY_SUPER_SECRET_PASSWORD");
		
		Calendar dateOfBirth = Calendar.getInstance();
		dateOfBirth.set(1993, 11, 20);
		
		//create a UserProfile instance
		
		UserProfile userProfile = new UserProfile("+91-7709732086", Gender.MALE, dateOfBirth.getTime(), "747", "2nd Cross",
				"Pashan Sus Road, Pashan", "Pune", "Maharashtra", "India", "411021");
		
		//Set child reference(UserProfile) in parent entity (user)
		user.setUserProfile(userProfile);
		
		//Set parent reference(user) in child entity (userProfile)
		userProfile.setUser(user);
		
		//Save Parent Reference (which will save the child as well)
		userRepository.save(user);
		
		//================================================
	}
}

package com.jpa.test.bootjpaeg;

import java.util.List;

// import java.util.Iterator;
// import java.util.List;
// import java.util.Optional;
// import java.util.function.Consumer;

// import javax.xml.transform.Result;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.jpa.test.dao.UserRepo;
// import com.jpa.test.entities.User;
// import com.jpa.test.entities.user;
// import com.jpa.test.entities.user;
import com.jpa.test.entities.User;

@SpringBootApplication
@EntityScan("com.jpa.test.entities")
@EnableJpaRepositories("com.jpa.test.dao")
public class BootjpaegApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(BootjpaegApplication.class, args);
        UserRepo userrepo = context.getBean(UserRepo.class);

		// User userx = new User();
		// userx.setName("Siddharth Satish kardile");
		// userx.setCity("Pune");
		// userx.setStatus("I am software Developer");

		// User user2 = userrepo.save(userx);

		// System.out.println(user2);

		// create object of user
		// User user1 = new User();
		// user1.setName("Siddharth");
		// user1.setCity("Delhi");
		// user1.setStatus("Python programmer");

		// User user2 = new User();
		// user2.setName("Sanket");
		// user2.setCity("Mp");
		// user2.setStatus("C++ programmer");

		// List<User> users = List.of(user1,user2);
		// save multiple object then use saveall method
		// Iterable<User> Resultuser = userrepo.saveAll(users);

		// Resultuser.forEach(user->{
		// 	System.out.println(user);
		// });

		// update the user id 5
		// Optional<User> optional = userrepo.findById(5);
		
		// User user = optional.get();
		// user.setName("Siddharth");

		// User result = userrepo.save(user);
		// System.out.println(result);
		

		// how to get the data
		// Iterable<User> itr = userrepo.findAll();
		// Iterator<User> iterator = itr.iterator();

		// while(iterator.hasNext())
		// {
		// 	User user = iterator.next();
		// 	System.out.println(user);
		// }

		// deleting the user element
		// userrepo.deleteById(3);
		// userrepo.deleteById(2);
		// System.out.println("Deleted");

		// itr.forEach(user->{System.out.println(user);});
        
		// Iterable<User> alluser = userrepo.findAll();
		// alluser.forEach(user->System.out.println(user));
		// userrepo.deleteAll(alluser);

		// List<User> use1 = userrepo.findByName("Siddharth");
		// List<User> use2 = userrepo.findByNameAndCity("Sanket","Mp");
		// use1.forEach(e->System.out.println(e));
		// use2.forEach(x->System.out.println(x));
		
        // List<User> allUser = userrepo.getAllUser();
		// allUser.forEach(e-> {
		// 	System.out.println(e);
		// });

		List<User> allUser = userrepo.getUserByName("Siddharth");
		allUser.forEach(e-> {
			System.out.println(e);
		});
        System.out.println("-----------------------");
        userrepo.getUsers().forEach(e->System.out.println(e));

		System.out.println("Saved user ");
	}
}



//  by default from crud Repository

/*
 * ----------------------
 * 
 * findAllbyId
 * findById
 * findAll
 * 
 * Custom finder Method / Derived Query Methods
 * data by name
 * data by name and password
 * data by name or password
 * data name starting with prefix
 * data by name like 'keyword'
 * 
 * Select * from user where name='something'
 * 
 * 
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference
 * 
 * public List<User> findByName( String name )
 * 
 * findByNameStartingWith( String prefix )
 * findByNameEndingWith( String suffix )
 * findByNameContaining( String words )
 * 
 * findByNameLike( String likepattern )
 * findByAgeLEssThan( int age )
 *  
 * findByAgeGreaterThanEqual( int age )
 * findByAgeIn( Collection<Integer> ages )
 * findByNameOrderByName( String name )
 * 
 * 
 * @Query
 *     JPQL query
 *     native query
 * 
 */


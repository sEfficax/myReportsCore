package com.FirstTask.First.task.user1;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

  
@Repository
public class UserDaoService {
	
	private static List<User> users= new ArrayList<>();
	private static int usersCount = 10;
	static {
		users.add(new User(1, "james",	10040.00, new Date()));
		users.add(new User(2, "david",	20600.00, new Date()));
		users.add(new User(3, "kavin",	30040.00, new Date()));
		users.add(new User(4, "rahul",	46000.00, new Date()));
		users.add(new User(5, "kiran",	50000.00, new Date()));
		users.add(new User(6, "antony",	60000.00, new Date()));
		users.add(new User(7, "krish", 	710000.00, new Date()));
		users.add(new User(8, "levis", 	80000.00,  new Date()));
		users.add(new User(9, "kranthi",90000.00,  new Date()));
		users.add(new User(10, "mike",	651000.00, new Date()));
		 
	}
	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	} 
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
	

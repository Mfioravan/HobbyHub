package edu.ycp.cs320.hobbyhub.server.persist;

import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.hobbyhub.shared.Hobby;
import edu.ycp.cs320.hobbyhub.shared.User;

public class FakeDatabase implements IDatabase {
	private List<User> userList; // list of USERS
	private List<Hobby> hobbyList;
	private int userID = 1;  // sets index of userID
	public FakeDatabase() {
		userList = new ArrayList<User>();
		
		hobbyList = new ArrayList<Hobby>();
		Hobby BasketBall = new Hobby();
		BasketBall.setName("BasketBall");
		BasketBall.setDescription("People throw a ball into a net while getting into each others' way. This is deemed to be 'fun'.");
		hobbyList.add(BasketBall);
		// Create initial user
		createAccount("jsmith","abc123", userID, "Joe", "Smith", "jsmith@jsmith.com");
		
		// etc.
		
		//userList.add(user1);
	}
	
	@Override
	public User getUser(String username){
		for (User user : userList) {
			if (user.getUserName().equals(username)){
				return user;
			}
		}
		return null;
	}
	
	@Override
	public User login(String username, String password) {
		for (User user : userList) {
			if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		
		// No such username/password
		return null;
	}

	@Override
	public void addAccount(User user) {
		userList.add(user);
	}

	@Override
	public boolean checkExistence(String username) {
		for (User user : userList) {
			if (user.getUserName().equals(username)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean verifyAccount(String username, String password) {
		User user = null;
		user = getUser(username);
		if (user == null) {
			return false;
		} else if (!user.getPassword().equals(password)) {
			System.out.println("Incorrect password for " + username);
			return false;
		}
		return true;
	}

	@Override
	public int getUserID(String username){
		return getUser(username).getuserID();		
	}
	
	@Override
	public User getIDUser(int userID){
		for (User user : userList){
			if (user.getuserID() == userID){
				return user;
		}
		}
		return null;
	}
	
	public Hobby getHobby(String hobbyName){
		for (Hobby hobby : hobbyList){
			if (hobby.getName() == hobbyName){
				return hobby;
			}
		}
		return null;
	}
	
	public boolean editAccount(int userID, String firstname, String lastname, String email, String city, String state){
		User user = getIDUser(userID);
		
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setUserEmail(email);
		user.setLocationCity(city);
		user.setLocationState(state);
		
		return true;
	}
	
	public boolean addHobby(int userID, Hobby hobby){
		User user = getIDUser(userID);
		user.addHobby(hobby);
		
		return true;
	}
	
	public boolean createAccount(String username, String password, int userID ,String firstname, String lastname, String email){
		User existing = getUser(username);
		
		if(existing != null){
			// FIXME
			System.out.println("Account already exists");
			return false;
		} else {
			System.out.println("Creating account for user: " + username + ", pass: " + password );
			User user = new User();
			user.setUserName(username);
			user.setPassword(password);
			user.setuserID(userID);
			user.setFirstName(firstname);
			user.setLastName(lastname);
			user.setUserEmail(email);
			userList.add(user);
			userID++;
			return true;
		}
	}
	
	public boolean removeHobby(String hobbyName, int userID){
		User user = getIDUser(userID);
		return user.removeHobby(hobbyName);
	}

	

}

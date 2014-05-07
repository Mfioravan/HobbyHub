package edu.ycp.cs320.hobbyhub.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.hobbyhub.server.persist.DatabaseProvider;
import edu.ycp.cs320.hobbyhub.shared.Hobby;
import edu.ycp.cs320.hobbyhub.shared.User;
import edu.ycp.cs320.hobbyhub.client.AccountManagementService;


public class AccountManagementServiceImpl extends RemoteServiceServlet 
			implements AccountManagementService{

	private static final long serialVersionUID = 1L;

	public boolean verifyAccount(String username, String password) {
		System.out.println("username is " + username + " and password is " + password);
		return DatabaseProvider.getInstance().verifyAccount(username, password);
	}
	
	public boolean createAccount(String username, String password, int userID ,String firstname, String lastname, String email){
		System.out.println("Account for " + firstname + lastname + " is being created.  Username is " + username + " and password is " + password);
		return DatabaseProvider.getInstance().createAccount(username, password, userID, firstname, lastname, email);
	}

	@Override
	public int getUserID(String username) {
		int ID = DatabaseProvider.getInstance().getUserID(username);
		System.out.println("User ID for " + username + "is " + ID);
		return DatabaseProvider.getInstance().getUserID(username);
	
	}

	public boolean addHobby(int UserID, Hobby hobby){
		return DatabaseProvider.getInstance().addHobby(UserID, hobby);
	}
	@Override
	public User getIDUser(int userID) {
		return DatabaseProvider.getInstance().getIDUser(userID);
	}
	
	public boolean editAccount(int userID, String firstname, String lastname, String email, String city, String state){
		return DatabaseProvider.getInstance().editAccount(userID, firstname, lastname, email, city, state);
	}
	
	public boolean removeHobby(String hobbyName, int userID){
		return DatabaseProvider.getInstance().removeHobby(hobbyName, userID);
	}
}


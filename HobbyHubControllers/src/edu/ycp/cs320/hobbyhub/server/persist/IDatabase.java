package edu.ycp.cs320.hobbyhub.server.persist;

import edu.ycp.cs320.hobbyhub.shared.User;

/**
 * Interface that describes the persistence operations.
 * 
 * @author mfiroava
 */
public interface IDatabase {
	/**
	 * Attempt to log in a user whose username and password are given.
	 * 
	 * @param username the username
	 * @param password the password
	 * @return a {@link User} object if successful, or null if there is no
	 *         such username/password combination
	 */
	public User login(String username, String password);
	
	/**
	 * Attempt to add an acount to database
	 * 
	 * @param user the user
	 */
	public void addAccount(User user);
	
	/**
	 * 
	 * Checks to see if the account already exists
	 * 
	 * @param username the username
	 * @return true if account exists, false otherwise
	 */
	public boolean checkExistence(String username);
}
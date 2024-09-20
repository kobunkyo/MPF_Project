package model;

import java.util.ArrayList;

public class Users {
	private static ArrayList<User> users;

	public static ArrayList<User> getUsers(){
		return users;
	}
	
	public static User getUsersByIndex(int index) {
		return users.get(index);
	}
	
	public static void addUsers(String name, String email, String password) {
		User user = new User(name, email, password, 100);
		users.add(user);
		return;
	}
	
	public static void setUsers(ArrayList<User> data) {
		users = data;
	}
}

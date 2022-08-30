package com.esolutions.microservice.services;

import java.util.ArrayList;
import java.util.List;

import com.esolutions.microservice.models.UserDTO;

public class UserMockedData {

	private List<UserDTO> users;
	
	private static int idGenerator = 4;
	
	private static UserMockedData instance = null;
	
	public static UserMockedData getInstance() {
		if(instance == null) {
			instance = new UserMockedData();
		}
		return instance;
	}
	
	public UserMockedData() {
		users = new ArrayList<UserDTO>();
		users.add(new UserDTO(1, "Homero", "Simpson"));
		users.add(new UserDTO(2, "Bart", "Simpson"));
		users.add(new UserDTO(3, "Lisa", "Simpson"));
	}
	
	public List<UserDTO> getAllUsers() {
		return users;
	}
	
	public UserDTO getUserById(int id) {
		for(UserDTO user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public List<UserDTO> searchUsers(String searchTerm) {
		List<UserDTO> searchedUsers = new ArrayList<UserDTO>();
		for(UserDTO user : users) {
			if(user.getName().toLowerCase().contains(searchTerm.toLowerCase()) || 
					user.getLastname().toLowerCase().contains(searchTerm.toLowerCase())) {
				searchedUsers.add(user);
			}
		}
		return searchedUsers;
	}
	
	public UserDTO createUser(UserDTO user) {
		user.setId(idGenerator);
		idGenerator ++;
		users.add(user);
		return user;
	}
	
	public UserDTO updateUser(UserDTO user, int id) {
		for(UserDTO userOld : users) {
			if(userOld.getId() == id) {
				int userIndex = users.indexOf(userOld);
				user.setId(userOld.getId());
				users.set(userIndex, user);
				return user;
			}
		}
		return null;
	}
	
	public boolean deleteUser(int id) {
		int userIndex = -1;
		for(UserDTO user : users) {
			if(user.getId() == id) {
				userIndex = users.indexOf(user);
				break;
			}
		}
		if(userIndex > -1) {
			users.remove(userIndex);
			return true;
		}
		return false;
	}
}

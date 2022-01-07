package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.UsersDataService;
import com.gcu.data.UsersInterface;
import com.gcu.model.UsersModel;

public class UsersBusinessService implements UsersInterface {

	
	@Autowired
	UsersDataService userDataService;
	
	@Override
	public List<UsersModel> getUsers() {
		return userDataService.getUsers();
	}
	
	@Override
	public UsersModel getId(int Id) {
		return userDataService.getId(Id);
	}

	@Override
	public List<UsersModel> searchUsers(String search) {
		return userDataService.searchUsers(search);
	}

	@Override
	public int addUser(UsersModel newUser) {
		return userDataService.addUser(newUser);
	}

	@Override
	public boolean deleteUser(long id) {
		return userDataService.deleteUser(id);
	}

	@Override
	public UsersModel updateUser(long IdToUpdate, UsersModel updatedUser) {
		return userDataService.updateUser(IdToUpdate, updatedUser);
	}

}

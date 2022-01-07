package com.gcu.data;

import java.util.List;
import com.gcu.model.UsersModel;

// UsersDataService implements UsersInterface
public interface UsersInterface {

	public UsersModel getId(int Id);
	
	public List<UsersModel> getUsers();
	
	public List<UsersModel> searchUsers(String search);
	
	public int addUser(UsersModel newUser);
	
	public boolean deleteUser(long id);
	
	public UsersModel updateUser(long IdToUpdate, UsersModel userModel);
	
}

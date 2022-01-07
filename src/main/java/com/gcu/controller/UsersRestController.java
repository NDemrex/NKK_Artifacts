package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.data.UsersInterface;
import com.gcu.model.UsersModel;

@RestController
@RequestMapping("/api/v1/users")
public class UsersRestController {

	@Autowired
	private UsersInterface usersBusinessService;

	@GetMapping("/")
	public List<UsersModel> getUsers() {
		return usersBusinessService.getUsers();
	}
	
	@GetMapping("/{id}")
	public UsersModel getId(@PathVariable(name = "id") int Id) {
		return usersBusinessService.getId(Id);
	}

	@GetMapping("/search/{searchTerm}")
	public List<UsersModel> searchUsers(@PathVariable(name = "searchTerm")String searchTerm) {
		return usersBusinessService.searchUsers(searchTerm);
	}

	@PostMapping("/")
	public UsersModel addUser(@RequestBody UsersModel newUser) {
		usersBusinessService.addUser(newUser);
		return newUser;
	}

	@DeleteMapping("/{id}")
	public boolean deleteUser(@PathVariable(name = "id") long id) {
		return usersBusinessService.deleteUser(id);
	}

	@PutMapping("/")
	public UsersModel updateUser(@RequestBody UsersModel updateUser) {
		return usersBusinessService.updateUser(updateUser.getId(), updateUser);
	}

}

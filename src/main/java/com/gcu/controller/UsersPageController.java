package com.gcu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.data.UsersInterface;
import com.gcu.model.SearchUserModel;
import com.gcu.model.UsersModel;

@Controller
@RequestMapping("/Users")
public class UsersPageController { 
	
	@Autowired
	private UsersInterface usersBusinessService; 

	/* User Actions */
	@GetMapping("/allUsers")
	public String showAllUsers(Model model) {
		List<UsersModel> users = usersBusinessService.getUsers();
		model.addAttribute("title", "Showing Users");
		model.addAttribute("UsersModel", new SearchUserModel());
		model.addAttribute("users", users);
		
		return "ShowAllUsers";

		}
	
	//Show the search form, WORKS
	@GetMapping("/searchUserForm")
	public String UserSearchForm(Model model) {
		// Display Login Form View
		model.addAttribute("title", "Search Artifacts");
		model.addAttribute("SearchUserModel", new SearchUserModel());
		return "UserSearchForm";
	}
	
	/* SEARCH user Part 2, 	Display the searched user  WORKS*/
	@PostMapping("/userSearchResults")
	public String showSearchedUsers(@Valid SearchUserModel searchUserModel, BindingResult bindingResult, Model model) {
		System.out.println("Performing search results for " + searchUserModel.getSearchTerm());
		// Check for validation errors
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Search for Users");
			return "UserSearchForm";
		}else {

		List<UsersModel> users = usersBusinessService.searchUsers(searchUserModel.getSearchTerm());
	
		model.addAttribute("title", "Search for Users");
		model.addAttribute("searchUserModel", searchUserModel);
		model.addAttribute("users", users);
		return "ShowAllUsers";
		}

	}
	
	
	
	
	/* Part 1 to editing the User change the mapping for users*/
	@PostMapping("/editUserForm")
	public String displayUserEditForm(UsersModel usersModel, Model model) {
		// Display new order form
		model.addAttribute("title", "Edit User");
		model.addAttribute("UsersModel", usersModel);
		return "UserEditForm";
	}
	
	/* Part 2
	 * process a request from the edit User html page
	*/
	@PostMapping("/userUpdate")
	public String updateUser(@Valid UsersModel user, BindingResult bindingResult, Model model) {
		//Grab the id of the user
		usersBusinessService.updateUser(user.getId(), user);

		// get updated list of all the orders
		List<UsersModel> editedUser = usersBusinessService.getUsers();

		// display all 
		model.addAttribute("users", editedUser);
	
		return "UserAdmin";
	}
	
	
	/* add new user - show the add form. part 1 */
	@GetMapping("/AddNewUser")
	public String displayAddUserForm(Model model) {
		// Display new order form
		model.addAttribute("title", "Add new User");
		model.addAttribute("UsersModel", new UsersModel());
		return "AddNewUser";
	}

	/*
	 * process a request after the add form is submitted. part 2
	 */
	@PostMapping("/addUser")
	public String addUser(@Valid UsersModel newUser, BindingResult bindingResult, Model model) {
		// add new user
		usersBusinessService.addUser(newUser);

		// get updated list 
		List<UsersModel> users = usersBusinessService.getUsers();

		// display all 
		model.addAttribute("users", users);
		model.addAttribute("searchUserModel", new SearchUserModel());
		return "ShowAllUsers";
	}
	
	/* ADMIN, DELETE AND EDIT WITHIN THE FORM Part 1 */
	@GetMapping("/adminUser")
	public String showUsersForAdmin(Model model) {

		// display all orders with delete and edit buttons
		List<UsersModel> users = usersBusinessService.getUsers();
		model.addAttribute("title", "Edit or delete Users below");
		model.addAttribute("searchUserModel", new SearchUserModel());
		model.addAttribute("users", users);

		// ordersAdmin page shows a table of orders including buttons for del and edit.
		return "UserAdmin";
	}

	/* DELETE USERS Part 2 of Admin, Edit is the other part*/
	@PostMapping("/deleteUser")
	public String deleteOrder(@Valid UsersModel user, BindingResult bindingResult, Model model) {
		// add the new order
		usersBusinessService.deleteUser(user.getId());

		// get updated list of all the users
		List<UsersModel> users = usersBusinessService.getUsers();

		// display all orders
		model.addAttribute("users", users);
		model.addAttribute("searchUserModel", new SearchUserModel());
		return "UserAdmin";
	}
}

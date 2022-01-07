package com.gcu.business;

import com.gcu.model.LoginModel;

public class ValidLogins implements SecurityServiceInterface {

	@Override
	public boolean isAuthenticated(LoginModel loginModel) {
		
		String[][] validLogins = new String[][] { { "nate", "password0" }, { "dogs", "password1" },
				{ "animals", "password2" }, { "monkey", "password3" }, { "password", "password4" } 
				};
				
		boolean success = false;
		for (int i = 0; i < validLogins.length; i++) {
			if (loginModel.getUsername().equals(validLogins[i][0])
					&& loginModel.getPassword().equals(validLogins[i][1])) {
				success = true;
			}
		}
		if (success) {
			// login success
			return true;
		} else {
			// we messed up
			return false;
		}
	}
}

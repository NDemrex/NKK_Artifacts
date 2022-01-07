package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UsersMapper implements RowMapper<UsersModel>{

	public 	UsersModel mapRow(ResultSet resultSet, int i) throws SQLException{
		
		UsersModel usersModel = new UsersModel(
			resultSet.getInt("id"),
			resultSet.getString("username"),
			resultSet.getString("password"),
			resultSet.getString("role")
				);
				
		return usersModel;
	}
	
}

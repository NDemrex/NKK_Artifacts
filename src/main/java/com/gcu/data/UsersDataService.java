package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.model.UsersMapper;
import com.gcu.model.UsersModel;

// This will talk to our database. CRUD
@Repository
public class UsersDataService implements UsersInterface {

	@Autowired
	DataSource datasource;
	JdbcTemplate jdbcTemplate;

	public UsersDataService(DataSource datasource) {
		this.datasource = datasource;

		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<UsersModel> getUsers() {
		return jdbcTemplate.query("SELECT * FROM `users`", new UsersMapper());
	}

	@Override
	public UsersModel getId(int Id) {
		UsersModel userID = jdbcTemplate.queryForObject("SELECT * FROM `users`  WHERE  id = ?", 
				new UsersMapper(),
				new Object[] { Id });
		return userID;

	}

	@Override
	public List<UsersModel> searchUsers(String search) {
		return jdbcTemplate.query("SELECT * FROM `users`  WHERE username LIKE ?", new UsersMapper(),
				new Object[] { "%" + search + "%" });
	}

	@Override
	public int addUser(UsersModel newUser) {
		return jdbcTemplate.update("insert into users (username, password, role) VALUES (?,?,?)",
			newUser.getUsername(), newUser.getPassword(), newUser.getRole());
	}

	@Override
	public boolean deleteUser(long id) {
		int removedUser = jdbcTemplate.update("delete from users where id = ?", new Object[] { id });
		return (removedUser > 0);
	}

	@Override
	public UsersModel updateUser(long IdToUpdate, UsersModel updateUser) {
		int result = jdbcTemplate.update(
				"update users set username = ?, password = ?, role = ? where id =?",
				updateUser.getUsername(), updateUser.getPassword(), updateUser.getRole(), IdToUpdate);
		if (result > 0) {
			return updateUser;
		} else {
			return null;
		}
	}

}

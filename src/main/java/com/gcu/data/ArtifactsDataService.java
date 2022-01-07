package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.gcu.model.ArtifactsMapper;
import com.gcu.model.ArtifactsModel;

//This is talking to the database, Artifacts Data Service
@Repository
public class ArtifactsDataService implements ArtifactsInterface {

	@Autowired
	DataSource datasource;
	JdbcTemplate jdbcTemplate;

	// JDBC will help when talking to the database, Data source will be used for our
	// properties in the src
	public ArtifactsDataService(DataSource datasource) {
		this.datasource = datasource;

		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	
	@Override
	public List<ArtifactsModel> getArtifacts() {
		return jdbcTemplate.query("select * from artifacts", new ArtifactsMapper());
	}
	
	
	@Override
	public ArtifactsModel getById(int Id) {
		ArtifactsModel artifactID = jdbcTemplate.queryForObject("select * from artifacts where ID = ?",
				new ArtifactsMapper(), 
				new Object[] { Id });
		return artifactID;
	}
	
	
	@Override
	public List<ArtifactsModel> searchArtifacts(String searchTerm) {
		return jdbcTemplate.query("select * from artifacts where ArtifactName LIKE ?", new ArtifactsMapper(),
				new Object[] { "%" + searchTerm + "%" });
	}


	@Override
	public int addOne(ArtifactsModel newArtifact) {
		return jdbcTemplate.update(
				"insert into artifacts( ArtifactName, Description, Age, Price, Quantity) values (?,?,?,?,?)",
				newArtifact.getName(), newArtifact.getDescription(), newArtifact.getAge(), newArtifact.getPrice(),
				newArtifact.getQuantity());
	}

	@Override
	public boolean deleteOne(long id) {
		int removedArtifact = jdbcTemplate.update("delete from artifacts where ID = ?", new Object[] { id });
		return (removedArtifact > 0);
	}

	
	@Override
	public ArtifactsModel update(long IdToUpdate, ArtifactsModel updateArtifact) {
		int result = jdbcTemplate.update(
				"update artifacts set ArtifactName = ?, Description = ?, Age = ?, Price = ?, Quantity = ? where ID = ?",
				updateArtifact.getName(), updateArtifact.getDescription(), updateArtifact.getAge(),
				updateArtifact.getPrice(), updateArtifact.getQuantity(), IdToUpdate);
		if (result > 0) {
			return updateArtifact;
		} else {
			return null;
		}
	}
}

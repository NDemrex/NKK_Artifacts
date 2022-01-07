package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ArtifactsMapper implements RowMapper<ArtifactsModel> {

	/*  
	 this linking the database and my model together 
	  
	 */
	public ArtifactsModel mapRow(ResultSet resultSet, int i) throws SQLException{
		ArtifactsModel artifactModel = new ArtifactsModel(
				resultSet.getInt("ID"),
			//	resultSet.getByte("ItemImage"),
				resultSet.getString("ArtifactName"),
				resultSet.getString("Description"),				
				resultSet.getInt("Age"),
				resultSet.getFloat("Price"),
				resultSet.getInt("Quantity")
				);
		return artifactModel;				
	}		
}
                  
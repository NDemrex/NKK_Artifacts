package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.ArtifactsInterface;
import com.gcu.data.ArtifactsDataService;
import com.gcu.model.ArtifactsModel;

public class ArtifactsBusinessService implements ArtifactsInterface {
	
	//this should be calling the database, and that should be implementing the SQL
	@Autowired
	ArtifactsDataService artifactDataService;


	@Override
	public List<ArtifactsModel> getArtifacts() {
		return artifactDataService.getArtifacts();
	}

	@Override
	public ArtifactsModel getById(int Id) {
		return artifactDataService.getById(Id);
	}

	@Override
	public List<ArtifactsModel> searchArtifacts(String searchTerm) {
		return artifactDataService.searchArtifacts(searchTerm);
	}

	@Override
	public int addOne(ArtifactsModel newArtifact) {
		return artifactDataService.addOne(newArtifact);
	}

	@Override
	public boolean deleteOne(long id) {
		return artifactDataService.deleteOne(id);
	}

	@Override
	public ArtifactsModel update(long IdToUpdate, ArtifactsModel updateArtifact) {
		return artifactDataService.update(IdToUpdate, updateArtifact);
	}

}

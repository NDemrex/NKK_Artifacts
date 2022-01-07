package com.gcu.data;

import java.util.List;

import com.gcu.model.ArtifactsModel;

// implemented by the artifactsdataservice

public interface ArtifactsInterface {
	
	public ArtifactsModel getById(int Id);

	public List<ArtifactsModel> getArtifacts();

	public List<ArtifactsModel> searchArtifacts(String searchTerm);

	public int addOne(ArtifactsModel newArtifact);

	public boolean deleteOne(long id);

	public ArtifactsModel update(long IdToUpdate, ArtifactsModel updateArtifact);

}

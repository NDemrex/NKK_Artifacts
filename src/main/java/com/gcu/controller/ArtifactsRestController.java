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

import com.gcu.data.ArtifactsInterface;
import com.gcu.model.ArtifactsModel;


@RestController
@RequestMapping("/api/v1/Artifacts")
public class ArtifactsRestController {

	@Autowired 
	private ArtifactsInterface artifactsBusinessService;

	@GetMapping("/")
	public List<ArtifactsModel> showAllArtifacts() {
		return artifactsBusinessService.getArtifacts();
	}

	@GetMapping("/{id}")
	public ArtifactsModel getById(@PathVariable(name = "id") int id) {
		return artifactsBusinessService.getById(id);
	}

	@GetMapping("/search/{searchTerm}")
	public List<ArtifactsModel> searchArtifacts(@PathVariable(name = "searchTerm") String searchTerm) {
		return artifactsBusinessService.searchArtifacts(searchTerm);
	}

	// add it with a 'Post'
	@PostMapping("/")
	public ArtifactsModel addOne(@RequestBody ArtifactsModel newOrder) {
		artifactsBusinessService.addOne(newOrder);
		return newOrder;
	}

	// we want to remove by ID 'Delete'
	@DeleteMapping("/{id}")
	public boolean deleteOne(@PathVariable(name = "id") long id) {
		return artifactsBusinessService.deleteOne(id);
	}

	// given a model and an ID number.
	// change the properties of one item, 'PUT'.
	@PutMapping("/")
	public ArtifactsModel update(@RequestBody ArtifactsModel updateArtifact) {
		return artifactsBusinessService.update(updateArtifact.getID(), updateArtifact);
	}

}

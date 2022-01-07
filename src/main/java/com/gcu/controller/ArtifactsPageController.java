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

import com.gcu.data.ArtifactsInterface;
import com.gcu.model.ArtifactsModel;
import com.gcu.model.SearchArtifactModel;

/* THIS IS CONTROLLING THE MAIN FORMS, REF THIS WHEN WE NEED TO DO MAPPING */
@Controller
@RequestMapping("/Artifacts")
public class ArtifactsPageController {

	/* This is Act 4, 'ordersControllerforpages' */
	@Autowired
	private ArtifactsInterface artifactsBusinessService;
	
	@GetMapping("/logout")
	public String logout(Model model) {
		
		return "Login";

	}
	
	@GetMapping("/all")
	public String showAllArtifacts(Model model) {

		List<ArtifactsModel> artifacts = artifactsBusinessService.getArtifacts();
		model.addAttribute("title", "Show all Artifacts");
		model.addAttribute("ArtifactsModel", new SearchArtifactModel());
		model.addAttribute("artifacts", artifacts);

		return "Artifacts";

	}
	
	/* GET ARTIFACTS, ALL, NAME Part 1*/
	@GetMapping("/searchForm")
	public String displaySearchForm(Model model) {
		// Display Login Form View
		model.addAttribute("title", "Search Artifacts");
		model.addAttribute("SearchArtifactModel", new SearchArtifactModel());
		return "ArtifactsSearchForm";
	}

	/* SEARCH artifact Part 2, 	Display the searched artifact */
	@PostMapping("/searchResults")
	public String showAllArtifacts(@Valid SearchArtifactModel searchModel, BindingResult bindingResult, Model model) {
		System.out.println("Performing search results for " + searchModel.getSearchTerm());
		// Check for validation errors
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Search for Artifacts");
			return "ArtifactsSearchForm";
		}else {

		List<ArtifactsModel> artifacts = artifactsBusinessService.searchArtifacts(searchModel.getSearchTerm());

		model.addAttribute("title", "Search for Artifacts");
		model.addAttribute("searchModel", searchModel);
		model.addAttribute("artifacts", artifacts);
		return "Artifacts";
		}

	}
	

	/* Part 1 to editing the artifact */
	@PostMapping("/editForm")
	public String displayEditForm(ArtifactsModel artifactModel, Model model) {
		// Display new order form
		model.addAttribute("title", "Edit artifact");
		model.addAttribute("ArtifactsModel", artifactModel);
		return "ArtifactEditForm";
	}
	
	/* Part 2
	 * process a request from the edit Artifact html page,
	 * data service artifact = one single model Edit Artifact
	 */
	@PostMapping("/doUpdate")
	public String updateArtifact(@Valid ArtifactsModel artifact, BindingResult bindingResult, Model model) {

		// add the new order
		artifactsBusinessService.update(artifact.getID(), artifact);

		// get updated list of all the orders
		List<ArtifactsModel> editedArtifact = artifactsBusinessService.getArtifacts();

		// display all 
		model.addAttribute("artifacts", editedArtifact);
	
		return "ArtifactAdmin";
	}
	

	/* add new artifact - show the add form. part 1 */
	@GetMapping("/AddNewArtifact")
	public String displayAddNewForm(Model model) {
		// Display new order form
		model.addAttribute("title", "Add new Artifact");
		model.addAttribute("ArtifactsModel", new ArtifactsModel());
		return "AddNewArtifact";
	}

	/*
	 * process a request after the add form is submitted. part 2
	 */
	@PostMapping("/addNew")
	public String addArtifact(@Valid ArtifactsModel newArtifact, BindingResult bindingResult, Model model) {
		// add new
		artifactsBusinessService.addOne(newArtifact);

		// get updated list 
		List<ArtifactsModel> artifacts = artifactsBusinessService.getArtifacts();

		// display all 
		model.addAttribute("Artifacts", artifacts);
		/* model.addAttribute("searchModel", new SearchArtifactModel()); */
		return "Artifacts";
	}

	/* ADMIN, DELETE AND EDIT WITHIN THE FORM Part 1 */
	@GetMapping("/admin")
	public String showOrdersForAdmin(Model model) {

		// display all orders with delete and edit buttons
		List<ArtifactsModel> orders = artifactsBusinessService.getArtifacts();
		model.addAttribute("title", "Edit or delete orders");
		model.addAttribute("SearchArtifactModel", new SearchArtifactModel());
		model.addAttribute("artifacts", orders);

		// ordersAdmin page shows a table of orders including buttons for del and edit.
		return "ArtifactAdmin";
	}

	/* DELETE ARTIFACT Part 2 of Admin, Edit is the other part*/
	@PostMapping("/delete")
	public String deleteOrder(@Valid ArtifactsModel artifact, BindingResult bindingResult, Model model) {
		// add the new order
		artifactsBusinessService.deleteOne(artifact.getID());

		// get updated list of all the orders
		List<ArtifactsModel> Artifacts = artifactsBusinessService.getArtifacts();

		// display all orders
		model.addAttribute("artifact", Artifacts);
		model.addAttribute("searchModel", new SearchArtifactModel());
		return "ArtifactAdmin";
	}

}

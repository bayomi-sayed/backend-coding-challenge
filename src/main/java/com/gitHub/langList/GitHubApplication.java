package com.gitHub.langList;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <h1>GitHub Application</h1> is an REST microservice that list the languages
 * used by the 100 trending public repos on GitHub.
 * <p>
 *
 * @author Bayomi Sayed
 * @version 1.0
 * @since 2020-12-28
 */

@SpringBootApplication
@RestController
public class GitHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitHubApplication.class, args);
	}

	/**
	 * <h2>gitHubReposList</h2> The main service of the GitHub Application
	 * 
	 * @return Map it's Key is language name and it's value contains ReturnNode
	 *         Object
	 */
	@GetMapping("/gitHubReposList")
	public Map<String, ReturnNode> gitHubReposList() {

		RestTemplate restTemplate = new RestTemplate();

		// repoCreatedDate Get date value for last 30 days ( from now ).
		LocalDate repoCreatedDate = LocalDate.now().minusDays(30);

		// Reformat repoCreatedDate as (YYYY-MM-DD) to use it in calling gitHub search
		// service
		String repoCreatedDateFormated = repoCreatedDate.getYear() + "-" 
				+ repoCreatedDate.getMonthValue() + "-"
				+ repoCreatedDate.getDayOfMonth();
		
        // getHubSearchRepoUrl getHub Search repo rest service url
		String getHubSearchRepoUrl = "https://api.github.com/search/repositories?q=created:>" 
					                + repoCreatedDateFormated
									+ "&per_page=100&sort=stars&order=desc";

		//Calling GitHub Search Repo Service and extract items list and store it in restResponselist
		List<LinkedHashMap<String, Object>> restResponselist = 
				(List<LinkedHashMap<String, Object>>) restTemplate
				.getForObject(getHubSearchRepoUrl, LinkedHashMap.class).get("items");
        
		//Initiate the rest service return map variable returnList
		Map<String, ReturnNode> returnList = new HashMap<String, ReturnNode>();
		
		//loop in restResponselist to populate the return list
		for (LinkedHashMap<String,Object> object : restResponselist) {
			// currentLang the current language  for the selected node 
			// if null set it by string "Not specifed"
			String currentLang = object.get("language") != null ? (String) object.get("language") : "Not specifed";
			
			//Get node with currentLang key from return list if exist
			ReturnNode crrNode = returnList.get(currentLang);
			
			if (crrNode == null) // if node not found create new return node
				crrNode = new ReturnNode(object);
			else { // else add new repo item to the items list in selected node 

				crrNode.getReposList().add(object);
				
				// set repo count with repo items size
				crrNode.setReposCount(crrNode.getReposList().size());
			}
			//add the node to the returned map
			returnList.put(currentLang, crrNode);

		}
		// RETURN MAP
		return returnList;
	}
}

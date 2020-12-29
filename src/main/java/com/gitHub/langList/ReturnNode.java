package com.gitHub.langList;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
/**
 * The ReturnNode class is an entity encapsulate single return node it contains 
 * An integer to keep track  Number of repos using  specific language
 * and The list of repos using this language.
 * @author  Bayomi Sayed
 * @version 1.0
 * @since   2020-12-28 
 */
public class ReturnNode {
    
	 /**
	  * An integer to keep track Number of repos using specific language.
	 */
	private Integer reposCount=0;
	
	/**
	 * list of repos using the specific language.
	*/
	private List<LinkedHashMap<String, Object>> reposList = new ArrayList<LinkedHashMap<String,Object>>();

	/**
	 * initiate new RetunNode and add repo to it's  reposList
	 * @param object Repo item
	 */
	public ReturnNode(LinkedHashMap<String,Object> object) {
		reposList.add(object);
		reposCount=1;
	}


	public Integer getReposCount() {
		return reposCount;
	}


	public void setReposCount(Integer reposCount) {
		this.reposCount = reposCount;
	}


	public List<LinkedHashMap<String, Object>> getReposList() {
		return reposList;
	}


	public void setReposList(List<LinkedHashMap<String, Object>> reposList) {
		this.reposList = reposList;
	}

	
    
    
    
}

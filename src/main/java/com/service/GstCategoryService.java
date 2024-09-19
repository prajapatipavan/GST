package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Entity.GstCategoryEntity;
import com.Repositry.GstcatagoryRepositry;
import com.factory.RepositoryFactory;

@Service
public class GstCategoryService {
	
	@Autowired
	RepositoryFactory factoryrepo;
	
	
	public GstCategoryEntity addcatogory(GstCategoryEntity catagory) {
		
		return  factoryrepo.getGstcatrepo().save(catagory);
	}
	
	public List<GstCategoryEntity> Listcategory(){
	
		return factoryrepo.getGstcatrepo().findAll();
	}

	

}

package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.Entity.GstCategoryEntity;
import com.Repositry.GstcatagoryRepositry;

@Service
public class GstCategoryService {
	
	@Autowired
	GstcatagoryRepositry gstcatrepo;
	
	
	public GstCategoryEntity addcatogory(GstCategoryEntity catagory) {
		
		return gstcatrepo.save(catagory);
	}
	
	public List<GstCategoryEntity> Listcategory(){
	
		return gstcatrepo.findAll();
	}

	

}

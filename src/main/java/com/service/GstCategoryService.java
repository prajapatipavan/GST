package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.GstCategoryEntity;
import com.Repositry.GstcatagoryRepositry;
import com.dto.GstCategorydto;
import com.factory.RepositoryFactory;

@Service
public class GstCategoryService {

	@Autowired
	RepositoryFactory factoryrepo;

	public GstCategorydto addcatogory(GstCategorydto catagorydto) {

		GstCategoryEntity gstCategory = CatagoriesdtoToCatagoriesEntity(catagorydto);

		GstcatagoryRepositry gstcatagoryrepo = factoryrepo.getGstcatrepo();

		GstCategoryEntity savecatagories = gstcatagoryrepo.save(gstCategory);

		return categoryEntityToCategoryDto(savecatagories);
	}

	  /**
     * Retrieves a list of all GST categories, converting them to DTOs.
     *
     * @return a list of GstCategorydto representing all GST categories
     */
    public List<GstCategorydto> listCategory() {
        // Retrieve all category entities from the repository
        List<GstCategoryEntity> categoryEntities = factoryrepo.getGstcatrepo().findAll();
        
        // Convert the list of entities to DTOs and return
        return categoryEntities.stream()
                               .map(this::categoryEntityToCategoryDto)
                               .collect(Collectors.toList());
    }


	public GstCategoryEntity CatagoriesdtoToCatagoriesEntity(GstCategorydto catagorydto) {

		GstCategoryEntity gstCategoryEntity = factoryrepo.getModelmapper().map(catagorydto, GstCategoryEntity.class);

		return gstCategoryEntity;
	}

	public GstCategorydto categoryEntityToCategoryDto(GstCategoryEntity catagory) {

		GstCategorydto gstcatagoriesdto = factoryrepo.getModelmapper().map(catagory, GstCategorydto.class);

		return gstcatagoriesdto;
	}

}

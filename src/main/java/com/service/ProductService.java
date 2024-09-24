package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.ProductEntity;
import com.dto.Productdto;
import com.factory.RepositoryFactory;

@Service
public class ProductService {
	
	@Autowired
	RepositoryFactory repositoryFactory;
	
	
	   /*
	    * product save in database
	    * 
	    * 
	    * */
	      public Productdto addProduct(Productdto productdto) {
		  
		   ProductEntity product = productdtoToPoductEntity(productdto);
		   
		    ProductEntity saveproduct = repositoryFactory.getProductRepositry().save(product);
	
		   return productEntityToProductdto(saveproduct);
		   
		   
	   }
	      
	      
	      
	      public List<Productdto> listproduct() {
	    	    List<ProductEntity> allProducts = repositoryFactory.getProductRepositry().findAll();

	    	    List<Productdto> collect = allProducts.stream()
	    	                                          .map(this::productEntityToProductdto)
	    	                                          .collect(Collectors.toList());

	    	    return collect;  
	    	}

	      
	      
	

               //	      Mapper conversion 
	            public  ProductEntity   productdtoToPoductEntity(Productdto productdto) {
		   
		         ProductEntity product = repositoryFactory.getModelmapper().map(productdto, ProductEntity.class);
		         
		        return product;
	            }
		        
		        public  Productdto   productEntityToProductdto(ProductEntity productEntity) {
		 		   
			         Productdto product = repositoryFactory.getModelmapper().map(productEntity, Productdto.class);
			         
			        return product;
		   
	   }
	   
}

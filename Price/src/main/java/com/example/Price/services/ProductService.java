package com.example.Price.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Price.domain.Product;
import com.example.Price.domain.ProductInfo;
import com.example.Price.domain.ProductList;
import com.example.Price.repo.ProductRepository;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductService {
	private ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Iterable<Product> lookup() {
		return productRepository.findAll();
	}

	/*
	 * public Iterable<ProductFromStream> lookupAll() { ProductFromStream ps = new
	 * ProductFromStream(); return ps.readProducts();
	 * 
	 * }
	 */
	public ProductList ProductFromStream ()
	{
		String adress ="https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma";
        RestTemplate restTemplate = new RestTemplate();
        ProductList productInfo=null;
        
      // ResponseEntity<ArrayList<ProductInfo>> response=  restTemplate.exchange(adress,HttpMethod.GET,null,new ParameterizedTypeReference<ArrayList<ProductInfo>>(){});
      //  ArrayList<ProductInfo> productInfo = response.getBody();
        
        
     
      // ProductList productInfo =   restTemplate.getForObject(adress, ProductList.class);
        
        String  productIn =   restTemplate.getForObject(adress, String.class);
        
        System.out.println(productIn);
        
        
        ObjectMapper mapper = new ObjectMapper();
        
    
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.WRAP_EXCEPTIONS , true);
        
        try {
			 productInfo =  mapper.readValue(productIn, ProductList.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

      
        
        return productInfo; 
	  	

	}



}

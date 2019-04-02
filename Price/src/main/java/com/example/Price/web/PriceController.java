package com.example.Price.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Price.domain.Product;
import com.example.Price.domain.ProductInfo;
import com.example.Price.domain.ProductList;
import com.example.Price.services.PriceService;
import com.example.Price.services.ProductService;

@RestController

public class PriceController {


@Autowired
PriceService priceService;
	
@RequestMapping(method=RequestMethod.GET,path= "/getprice/{labelType}")
public  ArrayList<Product>  getprice( @PathVariable (value = "labelType",required =false) String labelType
		)
{ 
   return priceService.getProduct(labelType);
		   	
}



}

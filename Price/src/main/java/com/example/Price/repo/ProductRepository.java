package com.example.Price.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.Price.domain.Product;

@RepositoryRestResource(collectionResourceRel ="packages", path="packages")
public interface ProductRepository  extends CrudRepository<Product,Integer>{

}

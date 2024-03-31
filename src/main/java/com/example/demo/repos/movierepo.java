package com.example.demo.repos;
import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.tables.movies;

public interface movierepo extends CrudRepository<movies,String>{
	
	movies findByMname(String name);
	
}

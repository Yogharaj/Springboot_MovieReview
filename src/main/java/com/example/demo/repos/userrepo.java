package com.example.demo.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.tables.users;

public interface userrepo extends CrudRepository<users,String>{
	
	@Query("SELECT count(u)>0 from users u where u.username=?1")
	boolean userexists(String name);

}

package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.tables.reviews;

import jakarta.transaction.Transactional;

public interface reviewrepo extends CrudRepository<reviews,Integer>{
	
	@Query("SELECT count(r)>0 FROM reviews r where r.mname=?1")
	boolean checkrec(String mname);
    
    @Modifying
    @Transactional
	@Query("UPDATE movies m SET m.rating=?2 where m.mname=?1")
	void updaterec(String mname,double rating);
	
   @Query("SELECT count(r) FROM reviews r WHERE r.mname = ?1")
   Integer getCountByMName(String mname);
	
	@Query("SELECT rating from movies where mname=?1")
	double getrating(String mname);
	
	@Query("SELECT mname,mdesc,rating from movies where mname=?1")
	String findBymname(String mname);
	
	@Modifying
    @Transactional
	@Query(value = "INSERT INTO reviews (mname, mreview, rating) VALUES (:mname, :mreview, :rating)", nativeQuery = true)
    void save1(@Param("mname") String mname, @Param("mreview") String mreview, @Param("rating") double rating);
}

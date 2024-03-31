package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.tables.watchlist;

import jakarta.transaction.Transactional;

public interface watchlistrepo extends CrudRepository<watchlist,Integer> {
	
	@Query("SELECT count(u)>0 from users u where u.username=?1 AND u.pass=?2")
	boolean checkrec(String name,String pass);

	@Query("SELECT w.mname from watchlist w where w.username=?1")
	List<String> getrec(String name);
	
	@Modifying
    @Transactional
	@Query(value = "INSERT INTO watchlist (username, mname, pass) VALUES (:name, :mname, :pass)", nativeQuery = true)
    void save1(@Param("name") String name, @Param("mname") String mname, @Param("pass") String pass);
	
	@Transactional
    @Modifying
    @Query("DELETE FROM watchlist e WHERE e.username = ?1 AND e.pass = ?2 AND e.mname = ?3")
    void del1(String name, String pass, String mname);
}

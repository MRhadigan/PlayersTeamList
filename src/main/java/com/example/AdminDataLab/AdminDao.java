package com.example.AdminDataLab;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.AdminDataLab.entity.Admin;



@Repository
@Transactional
public class AdminDao {
	
	@PersistenceContext
	EntityManager eManager;
	
	public Admin findByName(String n) {
		return eManager.find(Admin.class,  n);
	}
	
	public List<Admin> findAll() {
		TypedQuery<Admin> namedQuery= eManager.createNamedQuery("find_all_players", Admin.class);
		return namedQuery.getResultList();
	}

	public Admin update(Admin a) {
		return eManager.merge(a);
	}
	
	public void deleteByName(String n) {
		Admin a1 = findByName(n);
		eManager.remove(a1);
	}
	
}

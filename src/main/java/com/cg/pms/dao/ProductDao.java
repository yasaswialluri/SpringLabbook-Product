package com.cg.pms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.pms.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer>{

	   
	   

}

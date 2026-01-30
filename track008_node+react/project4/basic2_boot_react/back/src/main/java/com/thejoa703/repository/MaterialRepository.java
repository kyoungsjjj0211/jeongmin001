
package com.thejoa703.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thejoa703.entity.Material;



@Repository 
public interface MaterialRepository extends JpaRepository<Material, Long> {

//    Optional<Material> findByTitle(String title);
//
//
//    List<Material> findByTitleContaining(String keyword);
//
//
//    List<Material> findByCategory(String category);
//
//
//    List<Material> findByAllergyNotContaining(String allergy);
//    
//
//    List<Material> findBySeason(String season);
//	
//    
//    List<Material> findByTemperature(String temperature);
//    
//    List<Material> findByCalories100g(String calories100g);
//    
//    List<Material> findByEfficacy(String efficacy);
//    
//    List<Material> findByBuyguide(String buyguide);
//    
//    List<Material> findByTrimguide(String trimguide);
//    
//    List<Material> findByStoreguide(String storeguide);
//	
	
	}

//private String title;
//private String imageurl;
//private String category;
//private String allergy;
//private String season;
//private String temperature;
//private String calories100g;
//private String efficacy;
//private String buyguide;
//private String trimguide;
//private String storeguide;


//CREATE : save     -   INSERT INTO  테이블명 (컬럼1,컬럼2,,) values (?,?,,)
//READ   : findAll  -   SELECT  * from 테이블명  
//         findById -   SELECT  * from 테이블명   where id=? 
//UPDATE : save     -   update  테이블명   set 컬럼1=? ,컬럼2=?  where   id=? 
//DELETE : deleteById - delete from 테이블명   where id=?
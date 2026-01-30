package com.thejoa703.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "Material4")
@Getter  @Setter 
@NoArgsConstructor
public class Material {

//	  private String title;
//    private String imageurl;
//    private String category;
//    private String allergy;
//    private String season;
//    private String temperature;
//    private String calories100g;
//    private String efficacy;
//    private String buyguide;
//    private String trimguide;
//    private String storeguide;
//    private LocalDateTime created_at;
//    private LocalDateTime updated_at;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "Material4_seq")  
	@SequenceGenerator(name = "Material4_seq", sequenceName = "Material4_SEQ" , allocationSize = 1)
	private Long materialid;
	
	@Column(nullable = false, length = 100)
    private String title;
	
	@Column(length = 500)
    private String imageurl;
	
	@Column(length = 50)
    private String category;
	
	@Column(length = 100)
    private String allergy;
	
	@Column(length = 50)
    private String season;
	
	@Column(length = 50)
    private String temperature;
	

    private String calories100g;
	
	@Lob
    private String efficacy;
	
	@Lob
    private String buyguide;

	@Lob
    private String trimguide;

	@Lob
    private String storeguide;
	

	private LocalDateTime createdat; 
	

	private LocalDateTime updatedat; 
	
	@PrePersist //notnull 가능
	void onCreate() {
		this.createdat = LocalDateTime.now();
		this.updatedat = LocalDateTime.now();
	}
	
	@PreUpdate
	void onUpdate() { 
		this.updatedat = LocalDateTime.now();
	}
}

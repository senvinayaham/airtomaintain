package com.airtomaintain.maintenance.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Tools extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native", strategy="native")
	@Column(name="tools_id")
	private Long toolsId;
	
	@Id
	private Long toolsOem;
	
	private String toolsName;
	
	private String toolsNumber;
	
	private String toolsMfn;
	
	private Long toolsQty;

}

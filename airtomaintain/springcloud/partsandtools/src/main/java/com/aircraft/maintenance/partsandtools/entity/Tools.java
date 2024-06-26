package com.aircraft.maintenance.partsandtools.entity;

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

/**
 * @author senthilvinayahammurugan
 *
 */
@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Tools extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native", strategy="native")
	@Column(name="tools_id")
	private Long toolsId;
	
	@Column(name="tools_oem")
	private int toolsOem;
	
	@Column(name="tools_name")
	private String toolsName;
	
	
	@Column(name="tools_number")
	private String toolsNumber;
	
	@Column(name="tools_mfn")
	private String toolsMfn;
	
	@Column(name="tools_qty")
	private int toolsQty;

}

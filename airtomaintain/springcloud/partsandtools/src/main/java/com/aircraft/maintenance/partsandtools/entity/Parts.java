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

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Parts extends BaseEntity{
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native", strategy="native")
	@Column(name="parts_id")
	private Long partsId;
	
	@Column(name="parts_oem")
	private int partsOem;
	
	@Column(name="parts_name")
	private String partsName;
	
	@Column(name="parts_number")
	private String partsNumber;
	
	@Column(name="parts_mfn")
	private String partsMfn;
	
	@Column(name="parts_qty")
	private int partsQty;


}

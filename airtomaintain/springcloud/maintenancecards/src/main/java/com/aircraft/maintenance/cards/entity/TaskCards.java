package com.aircraft.maintenance.cards.entity;

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
public class TaskCards extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="native")
	@GenericGenerator(name="native", strategy="native")
	@Column(name="work_card_id")
	private Long workCardId;
	
	@Column(name="task_card_description")
	private String taskCardDescription;
	
	
	@Column(name="task_card_number")
	private String taskCardNumber;
	

}

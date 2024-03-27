package com.aircraft.maintenance.cards.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aircraft.maintenance.cards.entity.WorkCards;
import com.aircraft.maintenance.cards.entity.TaskCards;

@Repository
public interface TaskCardsRepository extends JpaRepository<TaskCards, Long>{

	
	Optional<TaskCards> findByTaskCardNumber(String taskCardNumber);
	
	@Transactional
	@Modifying
	void deleteByTaskCardNumber(String taskCardNumber);
}

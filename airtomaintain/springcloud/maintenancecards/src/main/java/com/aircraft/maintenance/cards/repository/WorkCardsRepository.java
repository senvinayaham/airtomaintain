package com.aircraft.maintenance.cards.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aircraft.maintenance.cards.entity.WorkCards;


@Repository
public interface WorkCardsRepository extends JpaRepository<WorkCards, Long>{

	Optional<WorkCards> findByWorkCardNumber(String workCardNumber);
	
	@Transactional
	@Modifying
	void deleteByWorkCardNumber(String workCardNumber);

}

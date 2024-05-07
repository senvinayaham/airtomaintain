package com.aircraft.maintenance.partsandtools.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aircraft.maintenance.partsandtools.entity.Parts;

import reactor.core.publisher.Mono;

@Repository
public interface PartsRepository extends JpaRepository<Parts, Long>{

	Optional<Parts> findByPartsNumber(String partsNumber);
	
	Mono<Parts> findByPartsNumber1(String partsNumber);
	
	@Transactional
	@Modifying
	void deleteByPartsNumber(String partsNumber);

}

package com.airtomaintain.maintenance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.airtomaintain.maintenance.entity.Parts;

@Repository
public interface PartsRepository extends JpaRepository<Parts, Long>{

	Optional<Parts> findByPartsNumber(String partsNumber);
	
	@Transactional
	@Modifying
	void deleteByPartsNumber(String partsNumber);

}

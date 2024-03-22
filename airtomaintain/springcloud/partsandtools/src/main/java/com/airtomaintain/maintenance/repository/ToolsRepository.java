package com.airtomaintain.maintenance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.airtomaintain.maintenance.entity.Parts;
import com.airtomaintain.maintenance.entity.Tools;

@Repository
public interface ToolsRepository extends JpaRepository<Tools, Long>{

	
	Optional<Tools> findByToolsNumber(String toolsNumber);
	
	@Transactional
	@Modifying
	void deleteByToolsNumber(String toolsNumber);
}

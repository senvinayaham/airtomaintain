package com.airtomaintain.maintenance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airtomaintain.maintenance.entity.Parts;

@Repository
public interface PartsRepository extends JpaRepository<Parts, Long>{

	Optional<Parts> findByPartsNumber(String partsNumber);
}

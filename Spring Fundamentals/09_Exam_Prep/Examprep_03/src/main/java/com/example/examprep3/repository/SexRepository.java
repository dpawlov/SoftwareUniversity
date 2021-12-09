package com.example.examprep3.repository;

import com.example.examprep3.model.entity.Sex;
import com.example.examprep3.model.enums.SexType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SexRepository extends JpaRepository<Sex, String> {

   Optional<Sex> findBySex(SexType type);
}

package com.example.DaggerheartCreator.repository;

import com.example.DaggerheartCreator.model.Ancestry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AncestryRepository extends JpaRepository<Ancestry, Long> {
}
package com.example.DaggerheartCreator.repository;

import com.example.DaggerheartCreator.model.CharacterClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterClassRepository extends JpaRepository<CharacterClass, Long> {

}

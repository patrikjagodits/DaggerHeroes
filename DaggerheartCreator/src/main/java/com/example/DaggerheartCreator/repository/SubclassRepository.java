package com.example.DaggerheartCreator.repository;

import com.example.DaggerheartCreator.model.Subclass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubclassRepository extends JpaRepository<Subclass, Long> {
    List<Subclass> findByPlayerClassId(Long playerClassId);
}

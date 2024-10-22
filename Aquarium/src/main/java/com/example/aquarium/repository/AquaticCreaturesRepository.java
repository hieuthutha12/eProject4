package com.example.aquarium.repository;

import com.example.aquarium.model.AquaticCreatures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AquaticCreaturesRepository extends JpaRepository<AquaticCreatures, Integer> {
    boolean existsByAreaId(Integer areaId);
    @Modifying
    @Transactional
    @Query("UPDATE AquaticCreatures a SET a.area.status = 'INACTIVE' WHERE a.area.id = ?1")
    void updateAreaIdToNullByAreaId(int areaId);
}

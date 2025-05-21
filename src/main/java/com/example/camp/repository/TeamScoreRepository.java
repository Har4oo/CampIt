package com.example.camp.repository;

import com.example.camp.model.TeamScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamScoreRepository extends JpaRepository<TeamScore, Long> {

}

package com.example.CavaBiere.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.CavaBiere.bo.Biere;

public interface BiereRepository extends JpaRepository<Biere, Long> {}

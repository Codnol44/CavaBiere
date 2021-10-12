package com.example.CavaBiere.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.CavaBiere.bo.Biere;
import com.example.CavaBiere.bo.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {}

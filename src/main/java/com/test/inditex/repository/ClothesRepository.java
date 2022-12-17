package com.test.inditex.repository;

import com.test.inditex.model.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Object> {
}

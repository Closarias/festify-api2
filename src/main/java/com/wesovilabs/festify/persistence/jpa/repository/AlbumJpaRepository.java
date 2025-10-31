package com.wesovilabs.festify.persistence.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wesovilabs.festify.persistence.jpa.entity.AlbumEntity;

public interface AlbumJpaRepository extends JpaRepository<AlbumEntity, Long>{
    
}

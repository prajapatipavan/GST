package com.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.GstRateEntity;

public interface GstRateRepositry extends JpaRepository<GstRateEntity,Integer>{

	List<GstRateEntity> findByActiveTrue();

}

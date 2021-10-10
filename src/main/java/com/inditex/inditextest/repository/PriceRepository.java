package com.inditex.inditextest.repository;

import com.inditex.inditextest.entity.Price;
import com.inditex.inditextest.entity.PriceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PriceRepository extends JpaRepository<Price, PriceId> {
}

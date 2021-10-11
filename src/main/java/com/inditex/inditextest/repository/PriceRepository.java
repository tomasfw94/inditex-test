package com.inditex.inditextest.repository;

import com.inditex.inditextest.entity.PriceEntity;
import com.inditex.inditextest.entity.PriceEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PriceRepository extends JpaRepository<PriceEntity, PriceEntityId> {
}

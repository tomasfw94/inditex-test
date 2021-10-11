package com.inditex.inditextest.repository;

import com.inditex.inditextest.entity.PriceEntity;
import com.inditex.inditextest.entity.PriceEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Transactional
public interface PriceJpaRepository extends JpaRepository<PriceEntity, PriceEntityId> {

    @Query(value = "SELECT TOP 1 * FROM INDITEX.PRICES p WHERE p.PRODUCT_ID = :productId AND p.BRAND_ID = :brandId AND :date between p.START_DATE and p.END_DATE ORDER BY PRIORITY DESC",
    nativeQuery = true)
    Optional<PriceEntity> findProductPriceByBrandIdAndDateWithHighestPriority(int productId, int brandId, LocalDateTime date);

}

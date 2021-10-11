package com.inditex.inditextest.repository;

import com.inditex.inditextest.entity.PriceEntity;
import com.inditex.inditextest.exception.PriceNotFoundException;
import com.inditex.inditextest.model.Brand;
import com.inditex.inditextest.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class PriceRepository implements IPriceRepository {

    private PriceJpaRepository priceJpaRepository;

    @Autowired
    public PriceRepository(PriceJpaRepository priceJpaRepository){
        this.priceJpaRepository = priceJpaRepository;
    }

    public Price findProductPriceByBrandIdAndDateWithHighestPriority(int productId, int brandId, LocalDateTime date) {
        PriceEntity priceEntity =
                priceJpaRepository.findProductPriceByBrandIdAndDateWithHighestPriority(productId, brandId, date)
                        .orElseThrow(() -> new PriceNotFoundException(productId, brandId, date));

        return mapPriceEntityToPrice(priceEntity);
    }

    private Price mapPriceEntityToPrice(PriceEntity priceEntity) {
        return Price.builder()
                .brand(new Brand(priceEntity.getBrand().getBrandId(), priceEntity.getBrand().getBrandName()))
                .startDate(priceEntity.getStartDate())
                .endDate(priceEntity.getEndDate())
                .priceList(priceEntity.getPriceList())
                .productId(priceEntity.getProductId())
                .priority(priceEntity.getPriority())
                .price(priceEntity.getPrice())
                .curr(priceEntity.getCurr()).build();
    }
}

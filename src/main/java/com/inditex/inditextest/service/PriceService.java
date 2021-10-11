package com.inditex.inditextest.service;

import com.inditex.inditextest.dto.PriceDto;
import com.inditex.inditextest.model.Price;
import com.inditex.inditextest.repository.PriceRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component("priceService")
public class PriceService implements IPriceService {

    private PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository){
        this.priceRepository = priceRepository;
    }

    @Override
    public PriceDto getProductPriceInformationByBrandAndDate(int productId, int brandId, LocalDateTime date) {
        Price price = priceRepository.findProductPriceByBrandIdAndDateWithHighestPriority(productId, brandId, date);
        return mapPriceToPriceDto(price);
    }

    private PriceDto mapPriceToPriceDto(Price price) {
        return PriceDto.builder()
                .productId(price.getProductId())
                .brandId(price.getBrand().getBrandId())
                .priceList(price.getPriceList())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .pvp(price.getPrice()).build();
    }
}

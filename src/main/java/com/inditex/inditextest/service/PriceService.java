package com.inditex.inditextest.service;

import com.inditex.inditextest.dto.PriceDto;
import com.inditex.inditextest.model.Price;
import com.inditex.inditextest.repository.IPriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service("priceService")
public class PriceService implements IPriceService {

    private IPriceRepository priceRepository;

    public PriceService(IPriceRepository priceRepository){
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

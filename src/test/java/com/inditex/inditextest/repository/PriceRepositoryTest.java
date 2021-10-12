package com.inditex.inditextest.repository;

import com.inditex.inditextest.entity.BrandEntity;
import com.inditex.inditextest.entity.PriceEntity;
import com.inditex.inditextest.exception.PriceNotFoundException;
import com.inditex.inditextest.model.Price;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceRepositoryTest {

    @InjectMocks
    PriceRepository repository;

    @Mock
    PriceJpaRepository jpaRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private static final int PRODUCT_ID = 999;
    private static final int PRICE_LIST = 999;
    private static final int BRAND_ID = 999;
    private static final String BRAND_NAME = "brand";
    private static final LocalDateTime DATE = LocalDateTime.now();
    private static final BigDecimal PRICE = BigDecimal.valueOf(999.99);

    @Test
    public void findProductPriceByBrandIdAndDateWithHighestPriority(){
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setBrandId(BRAND_ID);
        brandEntity.setBrandName(BRAND_NAME);

        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setBrand(brandEntity);
        priceEntity.setProductId(PRODUCT_ID);
        priceEntity.setPriceList(PRICE_LIST);
        priceEntity.setStartDate(DATE);
        priceEntity.setEndDate(DATE);
        priceEntity.setPrice(PRICE);

        Optional<PriceEntity> optionalPriceEntity = Optional.of(priceEntity);

        doReturn(optionalPriceEntity).when(jpaRepository).findProductPriceByBrandIdAndDateWithHighestPriority(PRODUCT_ID, BRAND_ID, DATE);

        Price priceFromRepository = repository.findProductPriceByBrandIdAndDateWithHighestPriority(PRODUCT_ID, BRAND_ID, DATE);

        assertEquals(PRODUCT_ID, priceFromRepository.getProductId());
        assertEquals(BRAND_ID, priceFromRepository.getBrand().getBrandId());
        assertEquals(BRAND_NAME, priceFromRepository.getBrand().getBrandName());
        assertEquals(PRICE_LIST, priceFromRepository.getPriceList());
        assertEquals(DATE, priceFromRepository.getStartDate());
        assertEquals(DATE, priceFromRepository.getEndDate());
        assertEquals(PRICE, priceFromRepository.getPrice());

        verify(jpaRepository).findProductPriceByBrandIdAndDateWithHighestPriority(PRODUCT_ID, BRAND_ID, DATE);
    }

    @Test(expected = PriceNotFoundException.class)
    public void findProductPriceByBrandIdAndDateWithHighestPriority_nullElement_throwsException(){
        Optional<PriceEntity> emptyOptional = Optional.empty();

        doReturn(emptyOptional).when(jpaRepository).findProductPriceByBrandIdAndDateWithHighestPriority(PRODUCT_ID, BRAND_ID, DATE);

        repository.findProductPriceByBrandIdAndDateWithHighestPriority(PRODUCT_ID, BRAND_ID, DATE);

        verify(jpaRepository).findProductPriceByBrandIdAndDateWithHighestPriority(PRODUCT_ID, BRAND_ID, DATE);
    }
}

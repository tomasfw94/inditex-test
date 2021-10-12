package com.inditex.inditextest.service;

import com.inditex.inditextest.dto.PriceDto;
import com.inditex.inditextest.model.Brand;
import com.inditex.inditextest.model.Price;
import com.inditex.inditextest.repository.IPriceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceServiceTest {

    @InjectMocks
    PriceService priceService;

    @Mock
    IPriceRepository priceRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private static final int BRAND_ID = 999;
    private static final Brand BRAND = new Brand(BRAND_ID, "brand");
    private static final LocalDateTime START_DATE = LocalDateTime.now().minusDays(1);
    private static final LocalDateTime END_DATE = LocalDateTime.now().plusDays(1);;
    private static final int PRICE_LIST = 999;
    private static final int PRODUCT_ID = 888;
    private static final int PRIORITY = 777;
    private static final BigDecimal PRICE = BigDecimal.valueOf(99.99);
    private static final String CURR = "EUR";

    private static final LocalDateTime TEST_DATE = LocalDateTime.now();

    @Test
    public void getProductPriceInformationByBrandAndDate(){
        Price priceFromRepository = Price.builder()
                .brand(BRAND)
                .startDate(START_DATE)
                .endDate(END_DATE)
                .priceList(PRICE_LIST)
                .productId(PRODUCT_ID)
                .priority(PRIORITY)
                .price(PRICE)
                .curr(CURR).build();

        doReturn(priceFromRepository).when(priceRepository).findProductPriceByBrandIdAndDateWithHighestPriority(PRODUCT_ID, BRAND_ID, TEST_DATE);

        PriceDto priceDtoFromService = priceService.getProductPriceInformationByBrandAndDate(PRODUCT_ID, BRAND_ID, TEST_DATE);

        assertEquals(priceFromRepository.getBrand().getBrandId(), priceDtoFromService.getBrandId());
        assertEquals(priceFromRepository.getStartDate(), priceDtoFromService.getStartDate());
        assertEquals(priceFromRepository.getEndDate(), priceDtoFromService.getEndDate());
        assertEquals(priceFromRepository.getPriceList(), priceDtoFromService.getPriceList());
        assertEquals(priceFromRepository.getProductId(), priceDtoFromService.getProductId());
        assertEquals(priceFromRepository.getPrice(), priceDtoFromService.getPvp());

    }

}

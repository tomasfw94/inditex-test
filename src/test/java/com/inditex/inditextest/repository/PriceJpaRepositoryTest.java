package com.inditex.inditextest.repository;

import com.inditex.inditextest.entity.BrandEntity;
import com.inditex.inditextest.entity.PriceEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PriceJpaRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PriceJpaRepository repository;

    private static final int BRAND_ID = 999;
    private static final String BRAND_NAME = "brand";
    private static final LocalDateTime START_DATE = LocalDateTime.now();
    private static final LocalDateTime END_DATE = LocalDateTime.now().plusDays(2);
    private static final int PRICE_LIST = 999;
    private static final int PRODUCT_ID = 999;
    private static final int PRIORITY = 999;
    private static final BigDecimal PRICE = BigDecimal.valueOf(999.99);
    private static final String CURR = "curr";

    @Test
    public void findProductPriceByBrandIdAndDateWithHighestPriority_findsPersistedEntity() {
        BrandEntity brand = new BrandEntity();
        brand.setBrandId(BRAND_ID);
        brand.setBrandName(BRAND_NAME);

        BrandEntity savedBrand = this.entityManager.persist(brand);

        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setBrand(savedBrand);
        priceEntity.setStartDate(START_DATE);
        priceEntity.setEndDate(END_DATE);
        priceEntity.setPriceList(PRICE_LIST);
        priceEntity.setProductId(PRODUCT_ID);
        priceEntity.setPriority(PRIORITY);
        priceEntity.setPrice(PRICE);
        priceEntity.setCurr(CURR);

        this.entityManager.persist(priceEntity);

        Optional<PriceEntity> priceEntityFromRepository = repository.findProductPriceByBrandIdAndDateWithHighestPriority(PRODUCT_ID, BRAND_ID, START_DATE.plusDays(1));

        assertEquals(priceEntity, priceEntityFromRepository.get());
    }

    @Test(expected = NoSuchElementException.class)
    public void findProductPriceByBrandIdAndDateWithHighestPriority_noValueFound() {
        Optional<PriceEntity> priceEntityFromRepository = repository.findProductPriceByBrandIdAndDateWithHighestPriority(PRODUCT_ID, BRAND_ID, START_DATE.plusDays(1));
        priceEntityFromRepository.orElseThrow();
    }

}

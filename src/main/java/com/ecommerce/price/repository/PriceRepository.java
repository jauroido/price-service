package com.ecommerce.price.repository;

import com.ecommerce.price.repository.model.Price;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PriceRepository extends JpaRepository<Price, String> {

  Optional<Price> findById(Long id);

  @Query(value = """
      SELECT * FROM PRICES
      WHERE :applicationDate BETWEEN START_DATE AND END_DATE
      AND PRODUCT_ID = :productId
      AND BRAND_ID = :brandId
      """, nativeQuery = true)
  List<Price> findByApplicationDateProductIdAndBrandId(
      LocalDateTime applicationDate,
      Long productId,
      Long brandId
  );
}

package com.ecommerce.price.service;

import com.ecommerce.price.controller.model.PriceResponse;
import com.ecommerce.price.repository.PriceRepository;
import com.ecommerce.price.repository.model.Price;
import com.ecommerce.price.repository.model.Product;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceService {

  private final PriceRepository priceRepository;

  public PriceResponse getPrice(LocalDateTime applicationDate, Long productId, Long brandId) {
    Optional<Price> price = priceRepository.findById(1L);
    return PriceResponse.builder()
        .productId(price.map(Price::getProduct).map(Product::getId).orElse(23L)).build();
  }
}

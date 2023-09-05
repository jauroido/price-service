package com.ecommerce.price.service;

import com.ecommerce.price.controller.model.PriceResponse;
import com.ecommerce.price.repository.PriceRepository;
import com.ecommerce.price.repository.model.Price;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class PriceService {

  private PriceRepository priceRepository;

  public PriceResponse getPrice(LocalDateTime applicationDate, Long productId, Long brandId) {
    Price price = priceRepository.getById("1");
    return PriceResponse.builder().productId(price.getProduct().getId()).build();
  }
}

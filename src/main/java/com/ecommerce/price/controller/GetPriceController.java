package com.ecommerce.price.controller;

import com.ecommerce.price.controller.model.PriceResponse;
import com.ecommerce.price.mapper.PriceMapper;
import com.ecommerce.price.repository.model.Price;
import com.ecommerce.price.service.PriceService;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
public class GetPriceController {

  private final PriceService priceService;

  private final PriceMapper priceMapper;

  @GetMapping
  public ResponseEntity<PriceResponse> getPrice(
      @RequestParam LocalDateTime applicationDate,
      @RequestParam Long productId,
      @RequestParam Long brandId
  ) {
    Optional<Price> price = priceService.getPrice(applicationDate, productId, brandId);
    return price.map(priceMapper::priceToPriceResponse)
        .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

}

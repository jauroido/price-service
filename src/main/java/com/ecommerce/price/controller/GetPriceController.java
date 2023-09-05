package com.ecommerce.price.controller;

import com.ecommerce.price.controller.model.PriceResponse;
import com.ecommerce.price.service.PriceService;
import java.time.LocalDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/prices")
public class GetPriceController {
  private PriceService priceService;

  @GetMapping
  public ResponseEntity<PriceResponse> getPrice(
      @RequestParam LocalDateTime applicationDate,
      @RequestParam Long productId,
      @RequestParam Long brandId
  ) {
    PriceResponse response = priceService.getPrice(applicationDate, productId, brandId);
    return ResponseEntity.ok(response);
  }

}
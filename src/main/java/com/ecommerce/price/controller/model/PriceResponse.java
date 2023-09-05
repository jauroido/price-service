package com.ecommerce.price.controller.model;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class PriceResponse {
  private Long productId;
  private Long brandId;
  private Integer priceList;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private Double finalPrice;
}

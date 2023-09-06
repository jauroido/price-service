package com.ecommerce.price.controller.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceResponse implements Serializable {
  private Long productId;
  private Long brandId;
  private Long priceList;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private Double finalPrice;
}

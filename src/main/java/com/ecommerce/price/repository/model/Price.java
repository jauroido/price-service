package com.ecommerce.price.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PRICES")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Price {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "BRAND_ID")
  private Brand brand;

  private ZonedDateTime startDate;
  private ZonedDateTime endDate;
  private Integer priceList;

  @ManyToOne
  @JoinColumn(name = "PRODUCT_ID")
  private Product product;

  private Integer priority;
  private BigDecimal price;
  private String curr;
}




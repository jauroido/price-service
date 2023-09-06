package com.ecommerce.price.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
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

  private Integer priceList;

  private Integer priority;

  private Double priceAmount;

  private String curr;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

  @ManyToOne
  @JoinColumn(name = "BRAND_ID")
  private Brand brand;

  @ManyToOne
  @JoinColumn(name = "PRODUCT_ID")
  private Product product;
}




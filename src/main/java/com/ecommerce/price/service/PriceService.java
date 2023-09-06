package com.ecommerce.price.service;

import com.ecommerce.price.repository.PriceRepository;
import com.ecommerce.price.repository.model.Price;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceService {

  private final PriceRepository priceRepository;

  public Optional<Price> getPrice(LocalDateTime applicationDate, Long productId, Long brandId) {

    List<Price> prices = priceRepository.findByApplicationDateProductIdAndBrandId(
        applicationDate,
        productId, brandId);

    return Stream.ofNullable(prices).flatMap(Collection::stream)
        .max(Comparator.comparing(Price::getPriority));
  }
}

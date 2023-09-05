package com.ecommerce.price.repository;

import com.ecommerce.price.repository.model.Price;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, String> {

  Optional<Price> findById(Long id);
}

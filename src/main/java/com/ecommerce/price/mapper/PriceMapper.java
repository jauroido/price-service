package com.ecommerce.price.mapper;

import com.ecommerce.price.controller.model.PriceResponse;
import com.ecommerce.price.repository.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceMapper {

  @Mapping(target = "finalPrice", source = "priceAmount")
  @Mapping(target = "productId", source = "price.product.id")
  @Mapping(target = "brandId", source = "price.brand.id")
  PriceResponse priceToPriceResponse(Price price);
}

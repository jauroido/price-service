package com.ecommerce.price.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class GetPriceControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void test2020061410() throws Exception {
    testPriceRequest("2020-06-14T10:00:00", 35455L, 1L, 35.5, 1L);
  }

  @Test
  void test2020061416() throws Exception {
    testPriceRequest("2020-06-14T16:00:00", 35455L, 1L, 25.45, 2L);
  }

  @Test
  void test2020061421() throws Exception {
    testPriceRequest("2020-06-14T21:00:00", 35455L, 1L, 35.5, 1L);
  }

  @Test
  void test2020061510() throws Exception {
    testPriceRequest("2020-06-15T10:00:00", 35455L, 1L, 30.5, 3L);
  }

  @Test
  void test2020061621() throws Exception {
    testPriceRequest("2020-06-16T21:00:00", 35455L, 1L, 38.95, 4L);
  }

  @Test
  void test2021061621() throws Exception {
    testPriceRequest("2021-06-16T21:00:00", 35455L, 1L, null, null);
  }

  private void testPriceRequest(String dateTime, Long productId, Long brandId,
      Double expectedFinalPrice, Long expectedPriceList) throws Exception {

    ResultActions resultActions = mockMvc.perform(
        MockMvcRequestBuilders.get("/prices").param("applicationDate", dateTime)
            .param("productId", productId.toString()).param("brandId", brandId.toString())
            .accept(MediaType.APPLICATION_JSON));

    if (expectedPriceList != null) {
      resultActions.andExpect(MockMvcResultMatchers.status().isOk())
          .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
          .andExpect(MockMvcResultMatchers.jsonPath("$.productId").value(productId))
          .andExpect(MockMvcResultMatchers.jsonPath("$.brandId").value(brandId))
          .andExpect(MockMvcResultMatchers.jsonPath("$.priceList").value(expectedPriceList))
          .andExpect(MockMvcResultMatchers.jsonPath("$.finalPrice").value(expectedFinalPrice));
    } else {
      resultActions.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
  }
}
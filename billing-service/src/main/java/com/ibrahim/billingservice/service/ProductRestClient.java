package com.ibrahim.billingservice.service;

import com.ibrahim.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductRestClient {
    @GetMapping("/products/{id}")
    Product findProductById(@PathVariable("id") Long id);
    @GetMapping("/products")
    PagedModel<Product> allProducts();
}

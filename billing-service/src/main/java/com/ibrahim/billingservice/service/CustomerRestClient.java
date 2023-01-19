package com.ibrahim.billingservice.service;

import com.ibrahim.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("customers/{id}")
    Customer findCustomerById(@PathVariable("id") Long id);
}

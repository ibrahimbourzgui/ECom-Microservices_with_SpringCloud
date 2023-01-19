package com.ibrahim.billingservice.web;

import com.ibrahim.billingservice.entities.Bill;
import com.ibrahim.billingservice.model.Product;
import com.ibrahim.billingservice.repository.BillRepository;
import com.ibrahim.billingservice.repository.ProductItemRepository;
import com.ibrahim.billingservice.service.CustomerRestClient;
import com.ibrahim.billingservice.service.ProductRestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;

    public BillRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }
    @GetMapping("/fullBill/{id}")
    public Bill bill(@PathVariable("id") Long id)
    {
        Bill bill= billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(pi->{
            pi.setProduct(productRestClient.findProductById(pi.getProductId()));
        });
        return bill;
    }
}

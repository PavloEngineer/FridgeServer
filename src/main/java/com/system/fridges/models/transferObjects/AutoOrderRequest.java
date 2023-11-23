package com.system.fridges.models.transferObjects;

import com.system.fridges.models.AutoOrder;
import com.system.fridges.models.Product;

import java.util.ArrayList;
import java.util.List;

public class AutoOrderRequest {

    public String phone;
    public String id;
    public String first_name;
    public String email;
    public String address;
    public String delivery_date;
    public List<ProductRequest> product;

    public AutoOrderRequest(AutoOrder autoOrder) {
        this.phone = autoOrder.getAccess().getUser().getPhoneNumber().replaceAll("[^0-9]", "");
        this.id =  Integer.toString(autoOrder.getOrderId());
        this.first_name = autoOrder.getAccess().getUser().getSurname();
        this.email = autoOrder.getAccess().getUser().getEmail();
        this.address = autoOrder.getAccess().getFridge().getOffice().toString();
        this.delivery_date = autoOrder.getDateDelivery().toString();
        this.product = convertToProductRequest(autoOrder);
    }

    private List<ProductRequest> convertToProductRequest(AutoOrder autoOrder) {
        List<ProductRequest> productRequests = new ArrayList<>();
        ProductRequest productRequest = new ProductRequest();
        productRequest.id = autoOrder.getProduct().getProductId();
        productRequest.number = autoOrder.getNumber();
        productRequests.add(productRequest);
        return productRequests;
    }
}

class ProductRequest {
    public int id;

    public int number;

    public int price = 20;
}



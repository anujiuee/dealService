package org.amazon.model;

import java.util.concurrent.atomic.AtomicLong;

public class Product {

    private Long id;
    private String productName;

    AtomicLong atomicLong = new AtomicLong();

    public Product(String productName) {
        this.id = atomicLong.getAndIncrement();
        this.productName = productName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                '}';
    }
}

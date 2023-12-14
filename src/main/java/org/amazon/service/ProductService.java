package org.amazon.service;

import org.amazon.exception.ProductNotExistException;
import org.amazon.model.Product;

public interface ProductService {

    public Product getProduct(long productId) throws ProductNotExistException;

    public Product createProduct(String productName);
}

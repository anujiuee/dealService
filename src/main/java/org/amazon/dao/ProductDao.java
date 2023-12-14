package org.amazon.dao;

import org.amazon.exception.ProductNotExistException;
import org.amazon.exception.UserNotExistException;
import org.amazon.model.Product;
import org.amazon.model.User;

import java.util.HashMap;

public class ProductDao {

    HashMap<Long, Product> productMap = new HashMap<>();

    public Product getProduct(long productId) throws ProductNotExistException {
        if(productMap.get(productId)==null) throw new ProductNotExistException("product not exist in our system");
        return productMap.get(productId);
    }

    public Product createProduct(String productName){
        Product product =  new Product(productName);
        productMap.put(product.getId(),product);
        return product;
    }
}

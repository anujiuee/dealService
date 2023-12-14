package org.amazon.service.impl;

import org.amazon.dao.ProductDao;
import org.amazon.exception.ProductNotExistException;
import org.amazon.model.Product;
import org.amazon.service.ProductService;

public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product getProduct(long productId) throws ProductNotExistException {
      return productDao.getProduct(productId);
    }

    public Product createProduct(String productName){
       return productDao.createProduct(productName);
    }
}

package com.example.product_management.repository;

import com.example.product_management.model.ProductType;

import java.util.List;

public interface IProductTypeRepository {
    public List<ProductType> getProductTypeList();
}

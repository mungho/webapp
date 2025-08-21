package com.example.product_management.service;

import com.example.product_management.model.ProductType;
import com.example.product_management.repository.IProductTypeRepository;
import com.example.product_management.repository.ProductTypeRepository;

import java.util.List;

public class ProductTypeService implements IProductTypeService {
    IProductTypeRepository productTypeRepository = new ProductTypeRepository();

    @Override
    public List<ProductType> getProductTypeList() {
        return productTypeRepository.getProductTypeList();
    }
}

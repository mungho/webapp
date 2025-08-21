package com.example.product_management.repository;

import com.example.product_management.model.ProductDTO;
import com.example.product_management.model.ProductType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductTypeRepository implements IProductTypeRepository {
    private final String SELECT_ALL = "SELECT * FROM product_type";

    public List<ProductType> getProductTypeList(){
        List<ProductType> productTypeList = new ArrayList<>();

        try(Connection connection = BaseRepository.getConnectDB();) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = Integer.parseInt(resultSet.getString("id"));
                String name = resultSet.getString("name");
                productTypeList.add(new ProductType(id,name));
            }
        } catch (SQLException e) {
            System.out.println("lỗi query");
        }
        return productTypeList;
    }
}

package com.example.product_management.repository;

import com.example.product_management.model.Product;
import com.example.product_management.model.ProductDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private final String SELECT_ALL = "SELECT p.id, p.name, p.price, p.stock, pt.name AS type_name FROM products p LEFT JOIN product_type pt ON p.type_id = pt.id;";
    private final String INSERT_PRODUCT = "INSERT INTO products(name, price, stock, type_id) VALUES (?, ?, ?,?);";
    private final String DELETE_PRODUCT = "DELETE FROM products WHERE id = ?;";
    private final String UPDATE_PRODUCT = "UPDATE products SET name= ?, price = ?, stock = ?, type_id = ? WHERE id = ?;";
    private final String SELECT_BY_NAME = "SELECT p.id, p.name, p.price, p.stock, pt.name AS type_name FROM products p LEFT JOIN product_type pt ON p.type_id = pt.id WHERE p.name LIKE ?;";

    @Override
    public boolean addProduct(Product product) {
        try(Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getStock());
            preparedStatement.setInt(4, product.getTypeId());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean updateProduct(int id, String name, double price, int stock, int typeId) {
        try(Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT)) {
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, price);
            preparedStatement.setInt(3, stock);
            preparedStatement.setInt(4, typeId);
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteProduct(int id) {
        try(Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT)) {
            preparedStatement.setInt(1, id);
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ProductDTO> getProductByName(String name) {
        List<ProductDTO> productList = new ArrayList<>();

        try(Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NAME)) {
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String pName = resultSet.getString("name");
                String pType = resultSet.getString("type_name");
                double pPrice = resultSet.getDouble("price");
                int pStock = resultSet.getInt("stock");

                productList.add(new ProductDTO(id, pName, pPrice, pStock, pType));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> productList = new ArrayList<>();

        try(Connection connection = BaseRepository.getConnectDB();) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = Integer.parseInt(resultSet.getString("id"));
                String name = resultSet.getString("name");
                String type = resultSet.getString("type_name");
                double price = Double.parseDouble(resultSet.getString("price"));
                int stock = Integer.parseInt(resultSet.getString("stock"));
                productList.add(new ProductDTO(id, name, price, stock, type));
            }
        } catch (SQLException e) {
            System.out.println("lỗi query");
        }
        return productList;
    }
}

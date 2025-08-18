package com.example.product_management.repository;

import com.example.product_management.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private final String SELECT_ALL = "select * from products;";
    private final String INSERT_PRODUCT = "INSERT INTO products(name, price, stock) VALUES (?, ?, ?);";
    private final String DELETE_PRODUCT = "DELETE FROM products WHERE id = ?;";
    private final String UPDATE_PRODUCT = "UPDATE products SET name= ?, price = ?, stock = ? WHERE id = ?;";
    private final String SELECT_BY_NAME = "SELECT * FROM products WHERE name LIKE ?;";


//    @Override
//    public boolean addProduct(Product product)
//
//        if (product.getName() != null && product.getPrice() > 0 && product.getStock() >= 0) {
//            productList.add(product);
//            return true;
//        } else {
//            return false;
//        }
//
//    }
//
//    @Override
//    public boolean updateProduct(int id, String name, double price, int stock) {
//        Product product = getProductByID(id);
//        if (product.getName() != null && product.getPrice() > 0 && product.getStock() >= 0) {
//            product.setName(name);
//            product.setPrice(price);
//            product.setStock(stock);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public boolean deleteProduct(int id) {
//        if (getProductByID(id) == null) {
//            return false;
//        } else {
//            productList.remove(getProductByID(id));
//            return true;
//        }
//    }
//
//    @Override
//    public List<Product> getProductByName(String name) {
//        return productList;
//    }
//
//    public Product getProductByID(int id) {
//        for (Product product : productList) {
//            if(product.getId() == id) {
//                return product;
//            }
//        }
//        return null;
//    }

    @Override
    public boolean addProduct(Product product) {
        try(Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getStock());

            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean updateProduct(int id, String name, double price, int stock) {
        try(Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT)) {
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, price);
            preparedStatement.setInt(3, stock);
            preparedStatement.setInt(4, id);
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
    public List<Product> getProductByName(String name) {
        List<Product> productList = new ArrayList<>();

        try(Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NAME)) {
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String pname = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int stock = resultSet.getInt("stock");

                productList.add(new Product(id, pname, price, stock));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();

        try(Connection connection = BaseRepository.getConnectDB();) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = Integer.parseInt(resultSet.getString("id"));
                String name = resultSet.getString("name");
                double price = Double.parseDouble(resultSet.getString("price"));
                int stock = Integer.parseInt(resultSet.getString("stock"));
                productList.add(new Product(id, name, price, stock));
            }
        } catch (SQLException e) {
            System.out.println("lỗi query");
        }
        return productList;
    }
}

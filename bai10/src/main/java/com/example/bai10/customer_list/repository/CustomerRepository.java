package com.example.bai10.customer_list.controller.repository;

import com.example.bai10.customer_list.controller.model.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository{
    static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer(
                "1",
                "Mai Văn Hoàn",
                LocalDate.of(1983, 8, 20),
                "Hà Nội",
                "https://htmediagroup.vn/wp-content/uploads/2022/11/Anh-giam-doc-nam-01-min.jpg"));

        customerList.add(new Customer(
                "2",
                "Nguyễn Văn Nam",
                LocalDate.of(1983, 8, 21),
                "Bắc Giang",
                "https://htmediagroup.vn/wp-content/uploads/2023/05/Anh-10-min.jpg.webp"));

        customerList.add(new Customer(
                "3",
                "Nguyễn Thái Hòa",
                LocalDate.of(1983, 8, 22),
                "Nam Định",
                "https://htmediagroup.vn/wp-content/uploads/2022/11/Anh-7-copy-min.jpg"));

        customerList.add(new Customer(
                "4",
                "Trần Đăng Khoa",
                LocalDate.of(1983, 8, 17),
                "Hà Tây",
                "https://htmediagroup.vn/wp-content/uploads/2023/05/Anh-6-min.jpg.webp"));

        customerList.add(new Customer(
                "5",
                "Nguyễn Đình Thi",
                LocalDate.of(1983, 8, 19),
                "Hà Nội",
                "https://htmediagroup.vn/wp-content/uploads/2023/03/Anh-profile-nam-3-min.jpg.webp"));
    }

    @Override
    public List<Customer> getAll() {
        return customerList;
    }
}

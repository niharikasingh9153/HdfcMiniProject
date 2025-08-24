package com.hdfc.minibank.dao;

import com.hdfc.minibank.domain.Customer;
import com.hdfc.minibank.util.DBConnectionUtil;

import java.sql.*;

public class CustomerDAO {

    public void registerCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO CUSTOMER (customer_id, name, email, phone, dob) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getId());
            stmt.setString(2, customer.getName());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getPhone());
            stmt.setDate(5, Date.valueOf(customer.getDob()));

            stmt.executeUpdate();
        }
    }

    public Customer getCustomerById(String id) throws SQLException {
        String sql = "SELECT * FROM CUSTOMER WHERE customer_id = ?";
        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Customer(
                        rs.getString("customer_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getDate("dob").toLocalDate()
                );
            }
        }
        return null;
    }
}

package Controller;

import Model.DAO;

import java.sql.*;
import java.util.Scanner;

public class BookController {

    public void addTacGia(String tenTacGia) {
        Connection connection = DAO.getConnection();
        String SQLcheck = "SELECT tacgia_id FROM tacgia WHERE name = ?";
        String SQL = "INSERT INTO tacgia (name) VALUES (?)";
        try {
            PreparedStatement check = connection.prepareStatement(SQLcheck);
            check.setString(1, tenTacGia);
            ResultSet resultSet = check.executeQuery();
            if (!resultSet.next()) {
                PreparedStatement insert = connection.prepareStatement(SQL);
                insert.setString(1, tenTacGia);
                insert.executeUpdate();
                System.out.println("Thêm tác giả thành công");
            } else {
                System.out.println("Thêm tác giả thành công");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void editbook() {

    }

    public void printBookInfo() throws SQLException {
        Connection connection = DAO.getConnection();
        String SQL = "SELECT books.book_id, books.name AS name, books.loaisach, \n" +
                "       tacgia.name AS tacgia, nhaxuatban.nhaxuatban AS nhaxuatban, \n" +
                "       books.namxuatban, books.soluong, books.giatien\n" +
                "FROM books\n" +
                "INNER JOIN tacgia ON books.tacgia_id = tacgia.tacgia_id\n" +
                "INNER JOIN nhaxuatban ON books.nhaxuatban_id = nhaxuatban.nhaxuatban_id;\n";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            // In ra tiêu đề của bảng
            System.out.println("Sách trong cửa hàng :");
            System.out.printf("%-10s %-30s %-20s %-20s %-20s %-20s %-20s %-20s \n", "ID", "Tên sách", "Loại sách", "Tác giả", "Nhà xuất bản", "Năm xuât bản", "Số lương", "Giá tiền");

            // Duyệt qua các kết quả và in ra thông tin của từng cuốn sách
            while (resultSet.next()) {
                int id = resultSet.getInt("book_id");
                String name = resultSet.getString("name");
                String loaisach = resultSet.getString("loaisach");
                String tacgia = resultSet.getString("tacgia");
                String nhaxuatban = resultSet.getString("nhaxuatban");
                String namxuatban = String.valueOf(resultSet.getDate("namxuatban"));
                int soluong = resultSet.getInt("soluong");
                double giatien = resultSet.getDouble("giatien");

                // In ra thông tin của từng cuốn sách
                System.out.printf("%-10s %-30s %-20s %-20s %-20s %-20s %-20s %-20s \n", id, name, loaisach, tacgia, nhaxuatban, namxuatban, soluong, giatien);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printTacGiaInfo() throws SQLException {
        Connection connection = DAO.getConnection();
        String SQL = "SELECT * FROM tacgia";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            // In ra tiêu đề của bảng
            System.out.println("Thông tin tác giả :");
            System.out.printf("%-10s %-20s \n", "ID", "Tên tác giả");

            while (resultSet.next()) {
                int id = resultSet.getInt("tacgia_id");
                String name = resultSet.getString("name");
                System.out.printf("%-10s %-20s \n", id, name);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


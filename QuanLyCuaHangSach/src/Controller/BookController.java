package Controller;

import Model.DAO;

import java.sql.*;

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
                System.out.println("Tác giả đã tồn tại!");
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
    public void addNhaXuatBan(String tenNhaXuatBan) {
        Connection connection = DAO.getConnection();
        String SQLcheck = "SELECT nhaxuatban_id FROM nhaxuatban WHERE nhaxuatban = ?";
        String SQL = "INSERT INTO nhaxuatban (nhaxuatban) VALUES (?)";
        try {
            PreparedStatement check = connection.prepareStatement(SQLcheck);
            check.setString(1, tenNhaXuatBan);
            ResultSet resultSet = check.executeQuery();
            if (!resultSet.next()) {
                PreparedStatement insert = connection.prepareStatement(SQL);
                insert.setString(1, tenNhaXuatBan);
                insert.executeUpdate();
                System.out.println("Thêm nhà xuất bản thành công");
            } else {
                System.out.println("Nhà xuất bản đã tồn tại!");
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

    public void addBook(String name, String loaisach, String tacgia, String nhaxuatban, String namxuatban, int soluong, double giatien) throws SQLException {
        Connection connection = DAO.getConnection();
        String SQL = "INSERT INTO books (name, loaisach, tacgia_id, nhaxuatban_id, namxuatban, soluong, giatien) values (?,?,?,?,?,?,?)";
        String SQLTacGia = "SELECT tacgia_id FROM tacgia WHERE name = ?";
        String SQLNhaXuatBan = "SELECT nhaxuatban_id FROM nhaxuatban WHERE nhaxuatban =?";
        try {
            PreparedStatement check1 = connection.prepareStatement(SQLTacGia);
            PreparedStatement check2 = connection.prepareStatement(SQLNhaXuatBan);
            check1.setString(1,tacgia); check2.setString(1,nhaxuatban);
            ResultSet resultSet1 = check1.executeQuery(); ResultSet resultSet2 = check2.executeQuery();
            int tacgia_id;
            if (resultSet1.next()){
                tacgia_id = resultSet1.getInt("tacgia_id");
            } else {
                addTacGia(tacgia);
                resultSet1 = check1.executeQuery();
                if (resultSet1.next()) {
                    tacgia_id = resultSet1.getInt("tacgia_id");
                } else {
                    throw new SQLException("Lỗi khi thêm tác giả mới.");
                }
            }
            int nhaxuatban_id;
            if(resultSet2.next()){
                nhaxuatban_id = resultSet2.getInt("nhaxuatban_id");
            } else {
                addNhaXuatBan(nhaxuatban);
                resultSet2 = check2.executeQuery();
                if(resultSet2.next()){
                    nhaxuatban_id = resultSet2.getInt("nhaxuatban_id");
                } else {
                    throw new SQLException("Lỗi khi thêm nhà xuất bản mới.");
                }
            }
            PreparedStatement insert = connection.prepareStatement(SQL);
            insert.setString(1,name);
            insert.setString(2,loaisach);
            insert.setString(3,tacgia = String.valueOf(tacgia_id));
            insert.setString(4,nhaxuatban = String.valueOf(nhaxuatban_id));
            insert.setString(5,namxuatban);
            insert.setInt(6,soluong);
            insert.setDouble(7,giatien);
            insert.executeUpdate();
            System.out.println("Thêm sách thành công");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
    public void findBooksByName(String Name) throws SQLException {
        Connection connection = DAO.getConnection();
        String SQL = "SELECT books.book_id, books.name AS name, books.loaisach, \n" +
                "       tacgia.name AS tacgia, nhaxuatban.nhaxuatban AS nhaxuatban, \n" +
                "       books.namxuatban, books.soluong, books.giatien\n" +
                "FROM books\n" +
                "INNER JOIN tacgia ON books.tacgia_id = tacgia.tacgia_id\n" +
                "INNER JOIN nhaxuatban ON books.nhaxuatban_id = nhaxuatban.nhaxuatban_id\n"+
                "WHERE books.name = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,Name);
            ResultSet resultSet = preparedStatement.executeQuery();
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
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


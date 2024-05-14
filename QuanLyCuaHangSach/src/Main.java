import Controller.BookController;
import Model.Book;
import Model.DAO;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Xin chào, đây là hiệu sách:");
        System.out.println("Lựa chọn chức năng: ");
        System.out.println("1: Xem thông sách trong cửa hàng ");
        System.out.println("2: Xem thông tin tác giả ");
        System.out.println("3: Thêm tác giả");
        System.out.println("4: Thêm nhà xuất bản");
        System.out.println("5: Thêm sách ");
        System.out.println("6: Xem thông sách trong cửa hàng ");
        System.out.println("7: Xem thông sách trong cửa hàng ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        DAO.getConnection();
        BookController bookController = new BookController();
        switch (a) {
            case 1:
                bookController.printBookInfo();
                break;
            case 2:
                bookController.printTacGiaInfo();
                break;
            case 3:
                scanner.nextLine();
                System.out.println("Nhập tên tác giả: ");
                String tacgia = scanner.nextLine();
                bookController.addTacGia(tacgia);
                break;
            case 4:
                scanner.nextLine();
                System.out.println("Nhập tên NXB: ");
                String nhaxuatban = scanner.nextLine();
                bookController.addNhaXuatBan(nhaxuatban);
                break;
            case 5:
                scanner.nextLine();
                System.out.println("Nhập thông tin sách:");
                System.out.print("Tên sách: ");
                String name = scanner.nextLine();

                System.out.print("Loại sách: ");
                String loaisach = scanner.nextLine();

                System.out.print("Tên tác giả: ");
                String addtacgia = scanner.nextLine();

                System.out.print("Tên nhà xuất bản: ");
                String addnhaxuatban = scanner.nextLine();

                System.out.print("Năm xuất bản: ");
                String namxuatban = scanner.nextLine();

                System.out.print("Số lượng: ");
                int soluong = scanner.nextInt();

                System.out.print("Giá tiền: ");
                double giatien = scanner.nextDouble();

                try {
                    bookController.addBook(name, loaisach, addtacgia, addnhaxuatban, namxuatban, soluong, giatien);
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    scanner.close();
                }
                break;
            case 6:
                scanner.nextLine();
                System.out.println("Nhập tên sách: ");
                String findName = scanner.nextLine();
                bookController.findBooksByName(findName);
        }
    }

}
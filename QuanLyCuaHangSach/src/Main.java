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
        System.out.println("4: Xem thông sách trong cửa hàng ");
        System.out.println("5: Xem thông sách trong cửa hàng ");
        System.out.println("6: Xem thông sách trong cửa hàng ");
        System.out.println("7: Xem thông sách trong cửa hàng ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        DAO.getConnection();
        BookController bookController = new BookController();
        switch (a) {
            case 1 :
                bookController.printBookInfo();
                break;
            case 2 :
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
                System.out.println("Nhap thong tin sach");
        }
    }

}
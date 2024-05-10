package Controller;

import Model.Book;

import java.util.List;
import java.util.Scanner;

public class BookController {
    private List<Book> bookDatabase;
    private final Scanner scanner;

    public BookController(List<Book> bookDatabase) {
        this.bookDatabase = bookDatabase;
        this.scanner = new Scanner(System.in);
    }

    public void addBook() {
        System.out.println("Nhập thông tin sách mới:");
        System.out.print("Mã sách: ");
        String maSach = scanner.nextLine();
        System.out.print("Tên sách: ");
        String tenSach = scanner.nextLine();
        System.out.print("Loại sách: ");
        String loaiSach = scanner.nextLine();
        System.out.print("Tên tác giả: ");
        String tenTacGia = scanner.nextLine();
        System.out.print("Nhà xuất bản: ");
        String nhaXuatBan = scanner.nextLine();
        System.out.print("Năm xuất bản: ");
        double namXuatBan = scanner.nextDouble();
        System.out.print("Số lượng: ");
        double soLuong = scanner.nextDouble();
        System.out.print("Giá tiền: ");
        double giaTien = scanner.nextDouble();
        Book newBook = new Book(maSach, tenSach, loaiSach, tenTacGia, nhaXuatBan, namXuatBan, soLuong, giaTien);
        bookDatabase.add(newBook);
        System.out.println("Sách mới đã được thêm vào danh sách.");
        printTable();
        printBookInfo(newBook);
    }

    private void editbook(){

    }

    private void printBookInfo(Book book) {
        System.out.println("Thông tin sách:");
        System.out.println("Mã sách: " + book.getMaSach());
        System.out.println("Tên sách: " + book.getTenSach());
        System.out.println("Loại sách: " + book.getLoaiSach());
        System.out.println("Tên tác giả: " + book.getTenTacGia());
        System.out.println("Nhà xuất bản: " + book.getNhaXuatBan());
        System.out.println("Năm xuất bản: " + book.getNamXuatBan());
        System.out.println("Số lượng: " + book.getSoLuong());
        System.out.println("Giá tiền: " + book.getGiaTien());
    }
    public void printTable() {
        System.out.println("Mã sách        Tên sách     Loại sách   Tác giả Nhà xuất bản    Năm xuất bản    Số lượng    Giá tiền");
        for (Book book : bookDatabase) {
            System.out.printf("%-8s %-16s %-12s %-12s %-14s %-14f %-9f $%.2f%n",
                    book.getMaSach(), book.getTenSach(), book.getLoaiSach(), book.getTenTacGia(), book.getNhaXuatBan(),
                    book.getNamXuatBan(), book.getSoLuong(), book.getGiaTien());
        }

    }

}


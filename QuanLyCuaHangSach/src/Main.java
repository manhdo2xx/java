import Controller.BookController;
import Model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Xin chào, đây là hiệu sách:");
        System.out.println("Lựa chọn chức năng: ");
        List<Book> books = new ArrayList<>();
        books.add((new Book("1","JAVA","Lập trình","A","Kim Đồng",2001,10,200000)));
        books.add((new Book("2","C","Lập trình","A","Kim Đồng",2001,10,200000)));
        books.add((new Book("3","C++","Lập trình","A","Kim Đồng",2001,10,200000)));
        books.add((new Book("4","C#","Lập trình","A","Kim Đồng",2001,10,200000)));
        BookController controller = new BookController(books);
        controller.addBook();
    }

}
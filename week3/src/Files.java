import java.awt.desktop.SystemSleepEvent;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Files {
    public static void main(String[] args) {
        //Tạo file
        try {
            File myFile = new File("test.txt");
            if (!myFile.exists()) {
                if (myFile.createNewFile()) {
                    System.out.println("File created: " + myFile.getName());
                } else {
                    System.out.println("File creation failed.");
                }
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //Ghi vào file
        try {
            FileWriter myFileWriter = new FileWriter("test.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            System.out.println("Nhập dữ liệu cho file (Ấn \"Enter + . + Enter\" để kết thúc) ");
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                if (input.equals(".")) {
                    break;
                }
                // Ghi dữ liệu vào file
                myFileWriter.write(input);
                myFileWriter.write("\n"); // Thêm dấu xuống dòng
            }
            bufferedReader.close(); // Đóng luồng đọc từ bàn phím
            myFileWriter.close(); // Đóng luồng ghi vào file
            System.out.println("Written to file.");
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        //in ra màn hình
        try {
            File myFile = new File("test.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // lấy thông tin file
        File myFile = new File("test.txt");
        if (myFile.exists()){
            System.out.println("File name: "+myFile.getName());
            System.out.println("Path: "+myFile.getAbsolutePath());
            System.out.println("Writeable: "+myFile.canWrite());
            System.out.println("Readable: "+myFile.canRead());
            System.out.println("File size: "+myFile.length()+ " bytes");
            Date date = new Date(myFile.lastModified());
            SimpleDateFormat sDF = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            System.out.println("File created time: "+ sDF.format(date));
        }
    }
}

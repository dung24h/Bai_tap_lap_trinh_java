import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- QUẢN LÝ TỆP NHỊ PHÂN ---");
            System.out.println("1. Ghi dữ liệu vào tệp");
            System.out.println("2. Đọc dữ liệu từ tệp");
            System.out.println("0. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Đọc bỏ dòng trống sau khi nhập số

            if (choice == 0) break;

            System.out.print("Nhập tên tệp (ví dụ: numbers.dat): ");
            String fileName = sc.nextLine();

            switch (choice) {
                case 1:
                    ghiDuLieu(fileName, sc);
                    break;
                case 2:
                    docDuLieu(fileName);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
        sc.close();
    }

    // Hàm Ghi dữ liệu - Yêu cầu 1
    public static void ghiDuLieu(String fileName, Scanner sc) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            System.out.print("Nhập số lượng số nguyên n = ");
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.print("Nhập số thứ " + (i + 1) + ": ");
                int val = sc.nextInt();
                dos.writeInt(val);
            }
            System.out.println("=> Đã ghi thành công " + n + " số vào tệp.");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi tệp: " + e.getMessage());
        }
    }

    // Hàm Đọc dữ liệu - Yêu cầu 2
    public static void docDuLieu(String fileName) {
        System.out.println("Nội dung tệp " + fileName + ":");
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (true) {
                try {
                    int val = dis.readInt();
                    System.out.print(val + " ");
                } catch (EOFException e) {
                    // Yêu cầu: Dừng đọc bằng cách bắt EOFException
                    System.out.println("\n=> Đã đọc xong toàn bộ tệp.");
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Lỗi: Không tìm thấy tệp " + fileName);
        } catch (IOException e) {
            System.err.println("Lỗi I/O: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
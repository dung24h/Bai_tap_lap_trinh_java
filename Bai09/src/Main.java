import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 1. Xây dựng lớp Student cài đặt Serializable
class Student implements Serializable {
    private static final long serialVersionUID = 1L; // Đảm bảo tính tương thích khi đọc/ghi
    String id;
    String name;
    double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Tên: " + name + " | GPA: " + gpa;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "students.dat";

        // --- BƯỚC 2 & 3: NHẬP VÀ GHI DANH SÁCH ---
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            System.out.println("Nhập danh sách sinh viên (Nhập ID là 'END' để dừng):");
            while (true) {
                System.out.print("Nhập ID: ");
                String id = sc.nextLine();
                if (id.equalsIgnoreCase("END")) break;

                System.out.print("Nhập tên: ");
                String name = sc.nextLine();
                System.out.print("Nhập GPA: ");
                double gpa = Double.parseDouble(sc.nextLine());

                Student st = new Student(id, name, gpa);
                oos.writeObject(st); // Ghi đối tượng vào tệp
            }
            System.out.println("=> Đã ghi danh sách vào tệp thành công.");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi tệp: " + e.getMessage());
        }

        // --- BƯỚC 4 & 5: ĐỌC VÀ IN DANH SÁCH + BẮT CÁC NGOẠI LỆ ---
        System.out.println("\n--- ĐỌC DANH SÁCH TỪ TỆP ---");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                try {
                    Student st = (Student) ois.readObject(); // Đọc đối tượng
                    System.out.println(st);
                } catch (EOFException e) {
                    // Bắt lỗi khi hết dữ liệu tệp
                    System.out.println("=> Đã đọc hết danh sách.");
                    break;
                } catch (ClassNotFoundException e) {
                    // Bắt lỗi khi không tìm thấy lớp Student (yêu cầu đề bài)
                    System.err.println("Không tìm thấy class Student!");
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Main{
    static void main(String[] args) {
        arrayList a=new arrayList();
        hashMap h=new hashMap();
        treeMap t=new treeMap();

        Book[] b={
                new Book("01", "Giai tich 1", "Ti", 2021),
                new Book("02", "Giai tich 2", "Teo", 2022),
                new Book("03", "Dai so tuyen tinh", "An", 2023),
        };

        System.out.println("---Quan li thu vien---");
        //--THEM SACH--
        for(Book it:b){
            a.them(it);
            h.them1(it);
            t.them2(it);
        }

        //--TIM SACH--
        String bookId="02";
        System.out.println("1. Sach can tim la: ");
        System.out.println("a. Tim theo ArrayList: ");
        a.tim(bookId);
        System.out.println("b. Tim theo HashMap: ");
        h.tim1(bookId);
        System.out.println("c. Tim theo TreeMap: ");
        t.tim2(bookId);

        //--Xoa sach--
        a.xoa(bookId);
        h.xoa1(bookId);
        t.xoa2(bookId);
        System.out.println();
        //--In danh sach sach sau khi thay doi--
        System.out.println("2. Danh sach sach sau khi thay doi la: ");
        System.out.println("a. In theo ArrayList:");
        a.in();
        System.out.println("b. In theo HashMap:");
        h.in1();
        System.out.println("c. In theo TreeMap:");
        t.in2();
    }
}
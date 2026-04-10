import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println(a/b);
        }
        catch(InputMismatchException e){
            System.out.println("Yeu cau nhap so nguyen");
        }
        catch(ArithmeticException e){
            System.out.println("Yeu cau mau so khac 0");
        }
        finally {
            System.out.println("Program finished");
        }
    }
}

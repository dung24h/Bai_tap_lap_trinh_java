import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        WorldCounter c=new WorldCounter();
        String s=sc.nextLine();
        c.analyze(s);
        c.displayResult();
        System.out.println(c.Fillter());

    }
}

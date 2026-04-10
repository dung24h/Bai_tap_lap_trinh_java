import java.util.Scanner;
public class Main {
    public static long useString(){
        String s="";
        long start=System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            s+="Hello";
        }
        long end=System.currentTimeMillis();
        return end-start;
    }
    public static long useStringBuffer(){
        StringBuffer s=new StringBuffer();
        long start=System.currentTimeMillis();
        for(int i=0;i<100000;i++){
            s.append("Hello");
        }
        long end=System.currentTimeMillis();
        return end-start;
    }
    public static String contentAnalysis(String s){
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='.' || s.charAt(i)=='?' || s.charAt(i)=='!'){
                cnt++;
            }
        }
        String t=s.replace("Java", "Python");
        return "So luong cau la: "+ cnt+"\n" + "Doan van sau thay doi la: " + t;
    }
    public static void main() {
        long time1=Main.useString();
        long time2=Main.useString();
        System.out.println("Thoi gian chay cua String: " + time1);
        System.out.println("Thoi gian chay cua StringBuffer: " + time2);
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(contentAnalysis(s));
    }
}

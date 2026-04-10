import java.util.Scanner;
import java.io.*;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap duong dan tep nguon: ");
        String sourcePath=sc.nextLine();
        System.out.println("Nhap duong dan tep dich: ");
        String destPath=sc.nextLine();

        BufferedReader br=null;
        PrintWriter pw=null;
        int lineCopy=0;

        try{
            File sourceFile=new File(sourcePath);
            if(!sourceFile.exists()){
                throw new FileNotFoundException("Source file not found.");
            }
            br=new BufferedReader(new FileReader(sourceFile));

            try{
                pw=new PrintWriter(new FileWriter(destPath));
            }
            catch(IOException e){
                System.out.println("Cannot create destination file.");
                return;
            }

            String line;
            while((line=br.readLine())!=null){
                pw.println(line);
                lineCopy+=1;
            }

            System.out.println("Sao chep thanh cong!");
            System.out.println("So dong da sao chep: "+lineCopy);
        }
        catch(FileNotFoundException e){
            System.err.println(e.getMessage());
        }
        catch(IOException e){
            System.out.println("I/O errol.");
            e.printStackTrace();
        }
        finally {
           try {
               if(br!=null) br.close();
               if(pw!=null) pw.close();
               sc.close();
           }
           catch(IOException e){
               System.err.println("Loi khi dong tep.");
           }
        }
    }
}

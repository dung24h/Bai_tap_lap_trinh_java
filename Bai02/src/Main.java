import java.util.Scanner;
public class Main {
    static void main() {
        Scanner sc=new Scanner(System.in);
        CustomerQueue q=new CustomerQueue();
        q.add(new Customer("1", "Khach A"));
        q.add(new Customer("2", "Khach B"));
        while(!q.Empty()!=false){
            MessageHistory h=new MessageHistory();
            boolean ok=true;
            Customer c=new Customer(q.xuly());
            System.out.println("Doan chat "+ c.getId());
            int t;
            while(ok){
                System.out.println("Nhan vien: ");
                String s=sc.nextLine();
                h.pushMessage(new Message(c.getId(), s));
                System.out.println("Tu van dung?(1/0)");
                t=Integer.parseInt(sc.nextLine());
                if(t==0){
                    h.Undo();
                    System.out.println("Nhan vien: ");
                    s=sc.nextLine();
                    h.pushMessage(new Message(c.getId(), s));
                }
                System.out.println("Khach: ");
                sc.nextLine();
                System.out.println("Ban con cau hoi gi nua khong?(1/0)");
                t=Integer.parseInt(sc.nextLine());
                if(t==0){
                    ok=false;
                }
            }
        }
    }
}

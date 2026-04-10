import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueue {
    LinkedList<Customer> order=new LinkedList<Customer>();

    public void add(Customer c){
        order.addLast(c);
    }

    public Customer xuly(){
        if(!order.isEmpty()){
            return order.pollFirst();
        }
        else{
            System.out.println("Khong con khach doi");
            return null;
        }
    }

    public boolean Empty(){
        return order.isEmpty();
    }
}

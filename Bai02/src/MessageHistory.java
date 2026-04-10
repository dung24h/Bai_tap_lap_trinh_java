import java.util.Stack;

public class MessageHistory {
    Stack<Message> st=new Stack<>();

    void pushMessage(Message s){

        st.push(s);
    }

    void Undo(){
        if(!st.empty()){
            st.pop();
        }
    }
    void viewLast(){
        if(!st.empty()){
            System.out.println(st.peek());
        }
    }
}

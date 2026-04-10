import java.util.ArrayList;

public class arrayList {
    private ArrayList<Book> a=new ArrayList<>();

    public void them(Book b){
        a.add(b);
    }

    public void tim(String Id){
        for(Book it:a){
            if(it.id.equals(Id)){
                System.out.println(it);
            }
        }
    }

    public void xoa(String Id){
        a.removeIf(b -> b.id.equals(Id));
    }

    public void in(){
        for(Book it:a){
            System.out.println(it);
        }
    }
}

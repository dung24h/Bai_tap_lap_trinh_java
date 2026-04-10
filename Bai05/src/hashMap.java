import java.util.HashMap;

public class hashMap {
    HashMap<String, Book> hashMap=new HashMap<>();

    public void them1(Book b){
        hashMap.put(b.id, b);
    }

    public void tim1(String id){
        System.out.println(hashMap.get(id));
    }

    public void xoa1(String id){
        hashMap.remove(id);
    }

    public void in1(){
        for(String p:hashMap.keySet()){
            System.out.println(hashMap.get(p));
        }
    }
}

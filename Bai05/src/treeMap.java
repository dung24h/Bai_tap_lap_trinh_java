import java.util.TreeMap;

public class treeMap {
    TreeMap<String, Book> treeMap=new TreeMap<>();

    public void them2(Book b){
        treeMap.put(b.id, b);
    }

    public void tim2(String id){
        System.out.println(treeMap.get(id));
    }

    public void xoa2(String id){
        treeMap.remove(id);
    }

    public void in2(){
        for(String p:treeMap.keySet()){
            System.out.println(treeMap.get(p));
        }
    }
}

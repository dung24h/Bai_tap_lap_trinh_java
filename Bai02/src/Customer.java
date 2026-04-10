public class Customer {
    private String id;
    private String name;

    public Customer(){

    }
    public Customer(String id, String name){
        this.id=id;
        this.name=name;
    }

    public Customer(Customer m){
        this.id=m.getId();
        this.name=m.getName();
    }

    String getId(){
        return id;
    }

    String getName(){
        return name;
    }
}

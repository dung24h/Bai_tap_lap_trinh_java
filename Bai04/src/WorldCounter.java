import java.util.HashMap;

public class WorldCounter {
    HashMap<String, Integer> mp = new HashMap<>();

    public void analyze(String text){
        String t = text.toLowerCase();
        String ans = "";
        for (int i = 0; i < t.length(); i++) {
            Character tmp = t.charAt(i);
            if (Character.isLetter(tmp)) {
                ans = ans + tmp;
            } else {
                ans += " ";
            }
        }
        String[] res=t.split("\\s+");
        for(String it:res){
            if(!mp.containsKey(it)){
                mp.put(it, 1);
            }
            else{
                mp.put(it, mp.get(it)+1);
            }
        }
    }

    public void displayResult(){
        for(var it:mp.entrySet()){
            System.out.println(it.getKey() +" "+ it.getValue());
        }
    }
    public String Fillter(){
        String res="";
        int fre=0;
        for(var it:mp.entrySet()){
            int tmp=it.getValue();
            if(tmp>fre){
                fre=tmp;
                res=it.getKey();
            }
        }
        return "Tu xuat hien nhieu nhat: "+res+". So lan: "+fre;
    }
}

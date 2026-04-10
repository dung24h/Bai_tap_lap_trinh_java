import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static String chuanHoa(String s) {
        String t = s.toLowerCase();
        String ans = "";
        for (int i = 0; i < t.length(); i++) {
            Character tmp = t.charAt(i);
            if (Character.isLetter(tmp)) {
                ans = ans + tmp;
            } else {
                ans += " ";
            }
        }
        return ans;
    }

    public static void main() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String res = chuanHoa(s);
        HashMap<String, Integer> mp = new HashMap<>();
        String[] t=res.split("\\s+");
        for(String it:t){
            if(!mp.containsKey(it)){
                mp.put(it, 1);
            }
            else{
                mp.put(it, mp.get(it)+1);
            }
        }
        ArrayList<String> a=new ArrayList<>();
        String fremax="";
        int cnt=0;
        for(var it:mp.entrySet()){
            int tmp=it.getValue();
            if(tmp>cnt){
                fremax=it.getKey();
                cnt=tmp;
            }
            if(tmp==1){
                a.add(it.getKey());
            }
        }
        System.out.println("Tu xuat hien nhieu nhat la: " + fremax +", voi so lan: " + cnt);
        System.out.println("Cac tu xuat hien 1 lan la: ");
        for(var it:a){
            System.out.println(it);
        }


    }
}

import java.util.ArrayList;
public class teamMethods {
    String homeT, guestT;
    static ArrayList<ArrayList<String>> combination = new ArrayList<ArrayList<String>>();
    public void allCombinations(ArrayList fl) {
        for(int i = 0; i < 8; i++){
            homeT = fl.get(i).toString();
            for(int j = 0; j < 8; j++){
                guestT = fl.get(j).toString();
                ArrayList<String> pair = new ArrayList<>();
                if(homeT != guestT){
                    pair.add(homeT);
                    pair.add(guestT);
                    combination.add(pair);
                }
            }
        }
    }
}



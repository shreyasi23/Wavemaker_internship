import java.util.ArrayList;
public class VoterInfo{
    public static ArrayList<Voter> voterList = new ArrayList<>();
    public void addVoterInfo() {
        voterList.add(new Voter(1001,"Shreya K",false));
        voterList.add(new Voter(1002,"Mona K",false));
        voterList.add(new Voter(1003,"Vasista K",false));
        voterList.add(new Voter(1004,"Aman G",false));
        voterList.add(new Voter(1005,"Vedant B",false));
    }
    public int greetVoter(int id) {
        int found = 0, index = 0;
        for(int i = 0; i < voterList.size(); i++){
            if(voterList.get(i).vid == id){
                found = 1;
                index = i;
                break;
            }
        }
        if(voterList.get(index).voted == true){
            System.out.println("You have already voted!");
            return 404;
        }
        else if (found == 1){
            System.out.println("Welcome "+voterList.get(index).vName+"!");
        }
        else{
            System.out.println("You have not registered for voting");
            return 404;
        }
        return found;
    }
}

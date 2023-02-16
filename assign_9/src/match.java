import java.util.ArrayList;

public class match extends teamMethods{
    int index, day;
    ArrayList teamPair = new ArrayList();
    ArrayList<ArrayList<String>> playingTeams = new ArrayList<ArrayList<String>>();
//    int[] daysList = {1, 2, 3, 4, 5, 6, 7};

    // the scheduleMatch function flow
    // pick the pair of team from the arraylist of all possible pairs/combinations
    // check the palyingTeams arraylist to check if that pair of team is already playing or not
    // if the pair is not present in the playingTeams arraylist then add it in the arraylist.
    // remove the pair from the all possible combinations arraylist to mark as that particular
    // combination has played a match.
    // in next iteration repeat the above steps and remove the pair added to playingTeams arraylist in the
    // previous iteration to make it available for other matches.
    public void scheduleMatch(){
        index = 0;
        day = 0;
        while(!(combination.isEmpty()) && index != combination.size()){
            teamPair = combination.get(index);
            if(!(playingTeams.contains(teamPair))){
                playingTeams.add(teamPair);
            }
            else{
                index++;
            }
            combination.remove(teamPair);
            if()
            //index++;
        }

    }
}

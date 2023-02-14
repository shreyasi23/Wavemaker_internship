import java.util.ArrayList;

public class Votes extends VoterInfo{
    ArrayList<ArrayList<String>> partyVotes = new ArrayList<ArrayList<String>>();
    int voterNo, totalVotes, winner;
    ArrayList<String> ABC_party = new ArrayList<>();
    ArrayList<String> PQR_party = new ArrayList<>();
    ArrayList<String> MNO_party = new ArrayList<>();
    public void addVotes(int vote, int id){
       for(int i = 0; i < voterList.size(); i++){
           if(voterList.get(i).vid == id) {
               voterNo = i;
           }
       }
       if(voterList.get(voterNo).voted == false){
           switch (vote){
               case 1:
               {
                   ABC_party.add(voterList.get(voterNo).vName);
                   voterList.get(voterNo).voted = true;
                   System.out.println("Thanks for voting! your vote has been recorded");
                   break;
               }
               case 2:
               {
                   PQR_party.add(voterList.get(voterNo).vName);
                   voterList.get(voterNo).voted = true;
                   System.out.println("Thanks for voting! your vote has been recorded");
                   break;
               }
               case 3:
               {
                   MNO_party.add(voterList.get(voterNo).vName);
                   voterList.get(voterNo).voted = true;
                   System.out.println("Thanks for voting! your vote has been recorded");
                   break;
               }
               default:
               {
                   System.out.println("Invalid code");
                   break;
               }
           }
       }
       else{
           System.out.println("You have already voted!");
       }
       partyVotes.add(ABC_party);
       partyVotes.add(PQR_party);
       partyVotes.add(MNO_party);
    }


    public void Winner(){
        totalVotes = ABC_party.size() + PQR_party.size() + MNO_party.size();
        if((ABC_party.size() > PQR_party.size()) && (ABC_party.size() > MNO_party.size())){
            System.out.println("Winner: "+ NomineeInfo.nomineeInfo.get(0).nName+" "+NomineeInfo.nomineeInfo.get(0).party);
            winner = 1;
        }
        else if((PQR_party.size() > ABC_party.size()) && (PQR_party.size() > MNO_party.size())){
            System.out.println("Winner: "+NomineeInfo.nomineeInfo.get(1).nName+" "+NomineeInfo.nomineeInfo.get(1).party);
            winner = 2;
        }
        else{
            System.out.println("Winner: "+NomineeInfo.nomineeInfo.get(2).nName+" "+NomineeInfo.nomineeInfo.get(2).party);
            winner = 3;
        }
    }

    public void showVotesAndVoters(){
        System.out.println("Votes gained out of total number of votes:");
        if(winner == 1){
            System.out.println("ABC: "+partyVotes.get(0).size()+" / "+totalVotes);
            System.out.println("Voters: "+ABC_party);
            System.out.println("PQR: "+partyVotes.get(1).size()+" / "+totalVotes);
            System.out.println("Voters: "+PQR_party);
            System.out.println("MNO: "+partyVotes.get(2).size()+" / "+totalVotes);
            System.out.println("Voters: "+MNO_party);
        }
        else if(winner == 2){
            System.out.println("PQR: "+partyVotes.get(1).size()+" / "+totalVotes);
            System.out.println("Voters: "+PQR_party);
            System.out.println("ABC: "+partyVotes.get(0).size()+" / "+totalVotes);
            System.out.println("Voters: "+ABC_party);
            System.out.println("MNO: "+partyVotes.get(2).size()+" / "+totalVotes);
            System.out.println("Voters: "+MNO_party);
        }
        else {
            System.out.println("MNO: " + partyVotes.get(2).size() + " / " + totalVotes);
            System.out.println("Voters: " + MNO_party);
            System.out.println("ABC: " + partyVotes.get(0).size() + " / " + totalVotes);
            System.out.println("Voters: " + ABC_party);
            System.out.println("PQR: " + partyVotes.get(1).size() + " / " + totalVotes);
            System.out.println("Voters: " + PQR_party);
        }
    }
}

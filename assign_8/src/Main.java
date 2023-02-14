import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // displaying nominee list
        NomineeInfo ni = new NomineeInfo();
        ni.addNomineeInfo();
        System.out.println("Nominee List:");
        ni.displayInfo();

        // Taking vote from the voters
        VoterInfo vi = new VoterInfo();
        vi.addVoterInfo();
        int n = VoterInfo.voterList.size();

        Votes v = new Votes();

        int code, id, voterCheck, count=0;
        boolean process = true;
        while(process != false) {
            System.out.println("\nEnter your voter ID: ");
            id = sc.nextInt();
            voterCheck = vi.greetVoter(id);
            if(voterCheck == 404){
                continue;
            }
            else{
                System.out.println("Vote for anyone by entering the code:");
                code = sc.nextInt();
                v.addVotes(code, id);
            }
            count++;
            if(count == n){
                process = false;
            }
        }

        // displaying results
        v.Winner();
        v.showVotesAndVoters();
    }
}
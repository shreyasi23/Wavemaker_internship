import java.util.*;
public class Main {
    public static void main(String[] args) {
        String teamName, homeGrd, tn;
        Scanner sc = new Scanner(System.in);
        ArrayList<team> teamList = new ArrayList<>();
        ArrayList<String> freeList = new ArrayList<>();
        System.out.println("Enter eight name and home ground of 8 teams: ");
        for(int i = 0; i < 8; i++){
            System.out.println("Team "+(i+1)+" name: ");
            teamName = sc.next();
            System.out.println("Team "+(i+1)+" home ground: ");
            homeGrd = sc.next();
            teamList.add(new team(teamName, homeGrd));
        }

        //System.out.println(teamList);

        // put teams into free list
        for(int i = 0; i < 8; i++){
            tn = teamList.get(i).name;
            freeList.add(tn);
        }
        //System.out.println(freeList);

        teamMethods tm = new teamMethods();
        tm.allCombinations(freeList);
        System.out.println(tm.combination);
    }
}
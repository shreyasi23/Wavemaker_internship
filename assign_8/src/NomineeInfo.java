import java.util.ArrayList;

public class NomineeInfo{
    static ArrayList<Nominee> nomineeInfo = new ArrayList<>();
    public void addNomineeInfo(){
        nomineeInfo.add(new Nominee("Mira M","ABC"));
        nomineeInfo.add(new Nominee("Shubham G","PQR"));
        nomineeInfo.add(new Nominee("Mikka S","MNO"));
    }

    public void displayInfo(){
        for(int i = 0; i < nomineeInfo.size(); i++){
            System.out.println(nomineeInfo.get(i)+", Code='"+(i+1)+"\'");
        }
    }
}

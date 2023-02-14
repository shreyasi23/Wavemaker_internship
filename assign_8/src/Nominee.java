public class Nominee {
    String  nName, party;
    Nominee(String nName, String party){
        this.nName = nName;
        this.party = party;
    }

    @Override
    public String toString() {
        return  "Name='" + nName + '\'' +
                ", Party='" + party + '\'';
    }
}

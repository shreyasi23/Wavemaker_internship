public class Voter {
    int vid; String vName; boolean voted;
    Voter(int vid, String vName, boolean voted){
        this.vid = vid;
        this.vName = vName;
        this.voted = voted;
    }

    @Override
    public String toString() {
        return "vid=" + vid +
                ", vName='" + vName + '\'';
    }
}

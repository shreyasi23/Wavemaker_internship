public class team {

    String name, homeGround;
    team(String name, String homeGround){
        this.name= name;
        this.homeGround = homeGround;
    }

    @Override
    public String toString() {
        return "team{" +
                "name='" + name + '\'' +
                ", homeGround='" + homeGround + '\'' +
                '}';
    }
}

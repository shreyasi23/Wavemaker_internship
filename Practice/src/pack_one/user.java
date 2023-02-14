package pack_one;

public class user {
    protected int id, age;
    protected String name;

    user(){
        this.id = 10;
        this.name = "Shreya";
        this.age = 21;
    }
    user(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

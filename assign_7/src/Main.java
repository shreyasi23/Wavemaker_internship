public class Main {
    public static void main(String[] args) {

        // object of normal phone
        System.out.println("Normal phone functions");
        Samsung_basic sb = new Samsung_basic();
        sb.makeCall("Shreya");
        sb.sendSms("Mona");
        sb.playSnakeGame();

        // object of smartphone
        System.out.println("Smartphone functions");
        Samsung_smart ss = new Samsung_smart();
        ss.makeCall("Shreyasi");
        ss.sendSms("Vaishnavi");
        ss.socialMedia();
        ss.playAngryBirds();
        ss.takePic();
        ss.useFlash();
    }
}
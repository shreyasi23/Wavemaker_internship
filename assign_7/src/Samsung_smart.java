import java.util.Scanner;
public class Samsung_smart extends Samsung_basic implements Camera, FlashLight{
    Scanner sc = new Scanner(System.in);
    @Override
    public void makeCall(String person) {
        int vc;
        super.makeCall(person);
        System.out.println("Do you want to switch to video call?(1/0)");
        vc = sc.nextInt();
        if(vc == 1){
            System.out.println("Switching to video call");
        }
        else{
            System.out.println("Continuing with voice call");
        }
    }

    public void playAngryBirds(){
        System.out.println("Enjoy playing angry birds!");
    }

    public void socialMedia(){
        System.out.println("Welcome to social media! connect with your friends");
    }

    public void takePic(){
        System.out.println("Tap the shutter button to click a picture(Press 1)");
        int shutter = sc.nextInt();
        if(shutter == 1) {
            System.out.println("taking picture...smile");
        }
        else{
            System.out.println("you tapped somewhere else, tap on the shutter button");
        }
    }

    public void useFlash(){
        System.out.println("Flashlight turned ON");
        System.out.println("Tap on the toggle button to turn OFF light(Press 0)");
        int toggle = sc.nextInt();
        if(toggle == 0){
            System.out.println("Flashlight turned OFF");
        }
    }
}

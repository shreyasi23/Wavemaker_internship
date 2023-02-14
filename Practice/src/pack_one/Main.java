package pack_one;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n, i, uid, uAge;
        String uName;
        Scanner sc = new Scanner(System.in);
        ArrayList<user> userList = new ArrayList<>();
//        user u1 = new user();
        System.out.println("Enter the number of users: ");
        n = sc.nextInt();
        for(i = 0; i < n; i++){
            System.out.println("User "+(i+1));
            System.out.println("Enter ID: ");
            uid = sc.nextInt();

            System.out.println("Enter Name: ");
            uName = sc.next();

            System.out.println("Enter Age: ");
            uAge = sc.nextInt();

            userList.add(new user(uid, uName, uAge));
        }
        System.out.println("Original list");
        System.out.println(userList);
        System.out.println("Sorted list");
        userSort us = new userSort();
        us.sortUserList(userList);
        System.out.println(userList);
    }
}
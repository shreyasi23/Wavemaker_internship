package pack_one;

import java.util.ArrayList;

public class userSort extends user{
    public void sortUserList(ArrayList<user> aList){
        int i,j,temp1,temp2;
        String temp3;
        for(i = 0; i < aList.size() - 1 ; i++){
            for(j = 0; j < aList.size()-1-i; j++){
                if(aList.get(j).id > aList.get(j+1).id){
                    temp1 = aList.get(j).id;
                    aList.get(j).id = aList.get(j+1).id;
                    aList.get(j+1).id = temp1;

                    temp2 = aList.get(j).age;
                    aList.get(j).age = aList.get(j+1).age;
                    aList.get(j+1).age = temp2;

                    temp3 = aList.get(j).name;
                    aList.get(j).name = aList.get(j+1).name;
                    aList.get(j+1).name = temp3;
                }
            }
        }
    }
}

package prototypes;

import org.junit.Test;

import java.util.ArrayList;

public class ServerAllocation {


    public static void main(String[] args) {


    }


    public static Integer getServerNumber(ArrayList<Integer> currentList) {
        if(currentList.size() < 1) return 1;
        Integer currentServerNumber = 1;
        while(currentList.contains(currentServerNumber)) {
            currentServerNumber++;
        }
        return currentServerNumber;
    }

}



package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DaysHome {

    public List<Integer> cellCompete(int[] states, int days)
    {
        HashSet<int[]> allStates = new HashSet<>();

        int[] curDay = states;
        boolean foundCycle = false;
        int cycle = 0;

        for(int i = 0; i < days; i++) {

            if(allStates.contains(curDay)) {
                days = days % cycle;
                foundCycle = true;
                break;
            }

            else {
                allStates.add(curDay);
                cycle++;
                curDay = nextState(curDay);
            }

        }

        if(foundCycle) {
            for(int j = 0; j < days; j++) {
                curDay = nextState(curDay);
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < curDay.length; i++) {
            result.add(curDay[i]);
        }
        return result;

    }


    public int[] nextState(int[] curState) {
        int[] nextState = new int[curState.length];

        for(int i = 0; i < curState.length; i++) {
            if(i == 0) {
                if(curState[i+1] == 0) nextState[i] = 0;
                else nextState[i] = 1;
                continue;
            }
            else if(i == curState.length - 1) {
                if(curState[i - 1] == 0) nextState[i] = 0;
                else nextState[i] = 1;
                continue;
            }
            if(curState[i-1] == 1 && curState[i + 1] == 1) nextState[i] = 0;
            else if(curState[i -1] == 0 && curState[i + 1] == 0) nextState[i] = 0;
            else nextState[i] = 1;
        }

        return nextState;
    }

    public static void main(String[] args) {
        DaysHome solution = new DaysHome();
//        System.out.println(solution.solve());
    }

}

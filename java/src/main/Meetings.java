package main;

import java.util.Arrays;
import java.util.Comparator;

/*

We are writing a tool to help users manage their calendars. Given an unordered list of times of day when people are busy, write a function that tells us the intervals during the day when ALL of them are available.
Each time is expressed as an integer using 24-hour notation, such as 1200 (12:00), 1530 (15:30), or 800 (8:00).
Sample input:
p1_meetings = [
  (1230, 1300),
  ( 845, 900),
  (1300, 1500),
]
p2_meetings = [
  ( 0, 844),
  ( 930, 1200),
  (1515, 1546),
  (1600, 2400),
]
p3_meetings = [
  ( 845, 915),
  (1515, 1545),
  (1235, 1245),
]
schedules1 = [p1_meetings, p2_meetings, p3_meetings]
schedules2 = [p1_meetings, p3_meetings]
Expected output:
findAvailableTimes(schedules1)
 => [  844,  845 ],
    [  915,  930 ],
    [ 1200, 1230 ],
    [ 1500, 1515 ],
    [ 1546, 1600 ]
findAvailableTimes(schedules2)
 => [    0,  845 ],
    [  915, 1230 ],
    [ 1500, 1515 ],
    [ 1545, 2400 ]
n = number of meetings
m = number of schedules


 */

public class Meetings {


    boolean isAvailable(int[][] meetings, int start, int end) {

        for(int i = 0; i < meetings.length; i++) {
            if(start <= meetings[i][0]) {
                if(end <= meetings[i][0]) return true;
                else return false;
            } else if(start < meetings[i][1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Meetings solution = new Meetings();
        int[][] meetings = new int[][] {{1230, 1300}, {845, 900}, {1300, 1500}};
        System.out.println(solution.isAvailable(meetings, 900, 1230)); //Return true
        System.out.println(solution.isAvailable(meetings, 1245, 1330)); //Return false
        System.out.println(solution.isAvailable(meetings, 1400, 1630)); //Return false
        System.out.println(solution.isAvailable(meetings, 1600, 1630)); //Return true
    }

}

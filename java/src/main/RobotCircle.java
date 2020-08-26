import java.util.HashMap;

class RobotCircle {
    public boolean isRobotBounded(String instructions) {
        int[] moves = new int[4];
        int dir = 0;
        for(int i = 0; i < instructions.length(); i++) {
            if(instructions.charAt(i) == 'L') dir = (dir + 4 - 1 )% 4;
            if(instructions.charAt(i) == 'R') dir = (dir + 1) % 4;
            if(instructions.charAt(i) == 'G') moves[dir]++;
        }
        return (dir != 0 || (moves[0] == moves[2]  && moves[1] == moves[3]));
    }




    public static void main(String[] args) {
        RobotCircle roboCop = new RobotCircle();
        System.out.println(roboCop.isRobotBounded("GG"));
        System.out.println(roboCop.isRobotBounded("GL"));
        System.out.println(roboCop.isRobotBounded("GGLLGG"));
        System.out.println(roboCop.isRobotBounded("GLGLGGLGL"));

    }
}

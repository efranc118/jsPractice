package main;

import java.util.Stack;



//TODO: Haven't figured this one out yet
public class CollectRainWater {

    class Wall {

        Wall(int height, int position) {
            this.height = height;
            this.position = position;
        }
        int height;
        int position;
    }

    public int trap(int[] height) {
        Stack<Wall> walls = new Stack<>();
//        int = 0;
        int current = 0;



    return 0;
    }


    public static void main(String[] args) {
        CollectRainWater solution = new CollectRainWater();
       // System.out.println(solution.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1})); //6
        System.out.println(solution.trap(new int[] {1,2,1,3,2,1,2,4,3,2,3,2})); //6
        System.out.println(solution.trap(new int[] {3,0,0,3,2,1,2,3,3,2,3,2}));
        System.out.println(solution.trap(new int[] {4,1,0,4,2,1,2,4,3,2,3,2}));
        System.out.println(solution.trap(new int[] {4,2,3})); //1
        System.out.println(solution.trap(new int[] {4,2,0,3,2,5})); //9
    }

}

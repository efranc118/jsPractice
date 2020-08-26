import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PeakElement {

    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        if(nums.length < 3) return nums[0] > nums[1] ? 0 : 1;
        int min = 0;
        int max = nums.length - 1;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(min + (max - min) / 2);
        ArrayList<Integer> alreadySeen = new ArrayList<>();
        alreadySeen.add(min + (max - min) / 2);
        while(!queue.isEmpty()) {
            int mid = queue.pop();
            if(nums[mid - 1]  < nums[mid] && nums[mid] > nums[mid + 1]) return mid;
            else {
                int upMin = mid + 1;
                int downMax = mid - 1;
                int upMid = upMin + (max - upMin) / 2;
                int downMid = min + (downMax - min) / 2;
                if(upMid < max && !alreadySeen.contains(upMid)) {
                    queue.push(upMid); // Check Above
                    alreadySeen.add(upMid);
                }
                if(downMid > min && !alreadySeen.contains(downMid)) {
                    queue.push(min + (downMax - min) / 2); // Check
                    alreadySeen.add(min + (downMax - min) / 2 );
                }
            }
        }
        return nums[0] > nums[nums.length - 1] ? 0 : nums.length - 1;
    }

    public int findPeakElementBinarySearch(int[] nums) {
        if(nums.length == 1) return 0;
        int min = 0;
        int max = nums.length - 1;

        while(min < max) {
            int mid = min + (max - min) / 2;

            if(nums[mid] < nums[mid + 1]) min = mid + 1;
            else max = mid;
        }
        return max;
    }



    public static void main(String[] args) {
        PeakElement peakElement = new PeakElement();
//        System.out.println(peakElement.findPeakElement(new int[]{1,2,3,1}));
//        System.out.println(peakElement.findPeakElement(new int[]{1,2,1,3,5,6,4}));
//        System.out.println(peakElement.findPeakElement(new int[]{1,2,1}));
//        System.out.println(peakElement.findPeakElement(new int[]{3,2,1}));
//        System.out.println(peakElement.findPeakElement(new int[]{1,2,3}));
        System.out.println(peakElement.findPeakElement(new int[]{1,2,3,4,5}));

    }
}

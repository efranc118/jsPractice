package main;

public class MedianTwoArrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] x;
        int[] y;
        if(nums1.length <= nums2.length) {
            x = nums1;
            y = nums2;
        }
        else {
            x = nums2;
            y = nums1;
        }
        int minX = 0;
        int maxX = x.length - 1;

        int medianLength = (x.length + y.length + 1) / 2;
        boolean isEven = false;
        if((x.length + y.length) % 2 == 0) isEven = true;

        int midX;
        int leftX;
        int leftY;
        int rightX;
        int rightY;
        while(minX <= maxX) {
            midX = minX + (maxX - minX) / 2;
            int midY = medianLength - midX;


            leftX = midX - 1 >= 0 && x.length > 0 ? x[midX - 1] : Integer.MIN_VALUE;
            leftY = midY - 1 >= 0 && y.length > 0 ? y[midY - 1] : Integer.MIN_VALUE;
            rightX = midX < x.length ? x[midX] : Integer.MAX_VALUE;
            rightY = midY < y.length ? y[midY] : Integer.MAX_VALUE;

            if(leftX <= rightY && leftY <= rightX) {
                if(isEven) return (double) (Math.max(leftX, leftY) + Math.min(rightX, rightY)) / 2;
                else return Math.max(leftX, leftY);
            } else if(leftX > rightY) {
                maxX = midX - 1;
            } else {
                minX = midX + 1;
            }
        }
        if(minX >= x.length) {
            rightX = Integer.MAX_VALUE;
            leftX = maxX >= 0 && x.length > 0 ? x[maxX] : Integer.MIN_VALUE;
            int midY = medianLength - minX;
            leftY = midY - 1 >= 0 ? y[midY - 1] : Integer.MIN_VALUE;
            rightY = midY < y.length ? y[midY] : Integer.MAX_VALUE;
        } else {
            leftX = Integer.MIN_VALUE;
            rightX = x[minX];
            int midY = medianLength - maxX;
            leftY = y[midY - 1];
            rightY = midY < y.length ? y[midY] : Integer.MAX_VALUE;
        }

        if(isEven) return (double) (Math.max(leftX, leftY) + Math.min(rightX,rightY )) / 2;
        return Math.max(leftX, leftY);

    }


    public static void main(String[] args) {
        MedianTwoArrays solution = new MedianTwoArrays();
        int[] arr1 = new int[] {5};
        int[] arr2 = new int[] {};

        System.out.println(solution.findMedianSortedArrays(arr1, arr2));
    }

}

/*Hi, here's your problem today. This problem was recently asked by AirBNB:

Given a sorted array, A, with possibly duplicated elements, find the indices of the first and last occurrences of a target element, x. Return -1 if the target is not found.

Example:
Input: A = [1,3,3,5,7,8,9,9,9,15], target = 9
Output: [6,8]

Input: A = [100, 150, 150, 153], target = 150
Output: [1,2]

Input: A = [1,2,3,4,5,6,10], target = 9
Output: [-1, -1]
*/
package main.java;

import java.util.Arrays;;

public class _4_First_and_Last_Indices_of_an_Element_in_a_Sorted_Array {

    public static void main(String[] args) {
        int arr1[] = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(arr1, 8))); // Output -> [3,4]
        System.out.println(Arrays.toString(searchRange(arr1, 7))); // Output -> [1,2]
        int arr2[] = {10};
        System.out.println(Arrays.toString(searchRange(arr2, 10))); // Output -> [0,0]
        int arr3[] = {};
        System.out.println(Arrays.toString(searchRange(arr3, 8))); // Output -> [-1,-1]
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        if(nums == null || nums.length == 0) {
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        ans[0] = searchFirstPosition(nums, target);
        //System.out.println("first " +ans[0]);
        ans[1] = searchLastPosition(nums, target);
        return ans;
    }
    
    public static int searchFirstPosition(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(end - start > 1) {
            if(nums[start] == target)
                return start;
            int mid = (start + end) / 2;
            if(nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        if(nums[start] == target)
            return start;
        if(nums[end] == target)
            return end;
        return -1;
    }
    
    public static int searchLastPosition(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(end - start > 1) {
            if(nums[end] == target)
                return end;
            int mid = (start + end)/2;
            if(nums[mid] > target) {
                end = mid -1;
            }
            else{
                start = mid;
            }
        }
        if(nums[end] == target)
            return end;
        if(nums[start] == target)
            return start;
        
        return -1;
    }
}
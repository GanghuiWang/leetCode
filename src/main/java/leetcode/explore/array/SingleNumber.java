package leetcode.explore.array;

import java.util.*;

public class SingleNumber {
    public static void main(String[] args) {
        int []input1 = {2,2,1};
        int []input2 = {9,4,9,8,4};
        System.out.println(singleNumber(input1));
        System.out.println(singleNumber(input2));

    }
    public static int singleNumber(int[] nums) {
        int sum1=0;
        int sum2=0;
        Set<Integer> integerSet=new HashSet<>();
        List<Integer> integerList = new ArrayList<Integer>();
        for (int i = 0; i <nums.length; i++) {
            integerSet.add(nums[i]);
            sum2+=nums[i];
        }
        for (int num:integerSet){
            sum1 +=num;
        }
        return 2*sum1-sum2;
    }
}

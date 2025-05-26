package com.datastructure.javaproject.dsa_problem.top100Problems;

public class MaximumProductSubArray {
    
    public static void main(String[] args) {
        int [] A = {-2,3,-2,4};

        int res = maxProduct(A);
        System.out.print(res + " ");
    }

    public static int maxProduct(int[] nums) {
        int ans = 0;
        int pre = 1, suf=1;
        if(nums.length==1){
            return nums[0];
        }
        for(int i=0;i<nums.length;i++){
            if(pre == 0) pre = 1;
            if(suf == 0) suf = 1;
            pre = pre*nums[i];
            suf = suf*nums[nums.length-i-1];
            ans = Math.max(ans, Math.max(pre, suf));
        }
        return ans;
    }
}

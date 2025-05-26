package com.datastructure.javaproject.dsa_problem.top100Problems.product_problem;

public class ProductSubarrayLessThanK {
    public static void main(String[] args) {
        int [] A ={10,5,2,6};
        System.out.println(numSubarrayProductLessThanK(A, 100));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        if(k <= 1) return 0;

        int count = 0;
        int product = 1;
        for(int left=0, right=0;right<nums.length;right++) {
            product *= nums[right];
            while(product >= k) {
                product /= nums[left++];
            }
            count += right-left+1;
        }
        
        return count;
    }
}

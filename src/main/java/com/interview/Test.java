package com.interview;

public class Test {
    //You are given a list of integers representing stock prices on consecutive days. 
    //Your task is to implement a method `maxProfit()` to find the maximum profit that can be achieved by buying and selling stocks on these days. 
    //However, you are allowed to make at most 
    //one transaction (i.e., buy one and sell one share of the stock), and you cannot sell a stock before you buy one.

    public static void main(String[] args) {
	    int[] stockPrices = new int[]{7, 1, 5, 3, 6, 4};
	    //Expected answer is : 5
	    
	    int maxProfit = getMaxProfit(stockPrices);
		System.out.println("Max profit is : "+maxProfit);
	}
	
	static int getMaxProfit(int[] stockPrices){
        int max = 0;
        for(int i=1;i<stockPrices.length;i++) {
                max = Math.max(max, stockPrices[i] - stockPrices[i-1]);
        }
	    return max;
	}
}

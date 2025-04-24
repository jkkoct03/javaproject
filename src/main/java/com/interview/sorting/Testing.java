package com.interview.sorting;

public class Testing {
    public static void main(String[] args) {
        
        
        int [] prices = {7,1,5,3,6,4};

        int buy=prices [0];
        int profit=0;
        for(int i=0; i<prices.length;i++){
        
        if(prices [0]<buy){
        
        buy= prices [i];
        
        }else {
        profit=prices[i]-buy;
        
        }
        
        System.out.println(profit);
        
        }
        Testing t = new Testing();
        System.out.println(t.hashCode());
        System.out.println(hashTest(t));
    }

    static int  hashTest(Object key){
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ h >>> 16;
    }
}

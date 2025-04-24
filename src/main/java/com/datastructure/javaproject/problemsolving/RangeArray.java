package com.datastructure.javaproject.problemsolving;

import java.util.ArrayList;
import java.util.List;

public class RangeArray {
 
    public List<List<Integer>> missingRanges(int[] A, int low, int upper) {
        List<List<Integer>> listOfList = new ArrayList<>();
    	int n = A.length;
    	int initVal = A[0];
        if(low != A[0]) {
            initVal = low;
        }
    	for(int j=0;j<n;j++) {
    	    List<Integer> listOfSet = new ArrayList<>();
    		for(int i=initVal+1;i<=upper;i++) {
    			 if(i == A[j] ) {
    				listOfSet.add(initVal);
    				listOfSet.add(A[j]-1);
    				initVal = i+1;
                    break;
    			 }  else if(i > A[j]) {
                    initVal = i;
                    break;
                 }
    		}
            if(!listOfSet.isEmpty()){
                listOfList.add(listOfSet);
            }
    	}

    	if(upper > A[n-1]){
    	    List<Integer> listOfSet = new ArrayList<>();
    		listOfSet.add(A[n-1]+1);
    		listOfSet.add(upper);
    		listOfList.add(listOfSet);
    	}
    	return listOfList;
    }

    public static void main(String[] args) {
        RangeArray ra = new RangeArray();
        int [] A = new int[] {-48, -10, -6, -4, 0, 4, 17};//{14, 15, 20, 30, 31, 45};
        System.out.println(ra.missingRanges(A, -54, 17));
    }
}
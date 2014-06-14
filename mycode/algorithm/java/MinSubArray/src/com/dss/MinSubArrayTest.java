package com.dss;

import org.junit.Assert;

public class MinSubArrayTest {

	public static void main(String[] args) {
		
		int[] test1 = new int[]{1, 2, 3, 4};
		Assert.assertEquals(10, MinSubArray.findMinSubArray(test1));
		
		int[] test2 = new int[]{-1, -2, -3, -4};
		Assert.assertEquals(-1, MinSubArray.findMinSubArray(test2));
		
		int[] test3 = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		Assert.assertEquals(43, MinSubArray.findMinSubArray(test3));		
	}
}

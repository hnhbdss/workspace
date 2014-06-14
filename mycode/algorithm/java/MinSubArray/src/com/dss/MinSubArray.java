package com.dss;

public class MinSubArray {
	
	private static class Result {
		private int left;
		private int right;
		private int sum;
		
		public Result(int left, int right, int sum) {
			this.left = left;
			this.right = right;
			this.sum = sum;
		}
		
		public int getLeft() {
			return left;
		}
		public void setLeft(int left) {
			this.left = left;
		}
		public int getRight() {
			return right;
		}
		public void setRight(int right) {
			this.right = right;
		}
		public int getSum() {
			return sum;
		}
		public void setSum(int sum) {
			this.sum = sum;
		}
	}
	
	public static int findMinSubArray(int[] target) {
		
		Result result = findMinSubArray(target, 0, target.length - 1);
		return result.getSum();
	}
	
	private static Result findMinSubArray(int[] target, int low, int high) {
		
		if (low >= high) {
			return new Result(low, high, target[low]);
		}
		
		int mid = (high + low) / 2;
		
		Result leftResult = findMinSubArray(target, low, mid);
		
		Result rightResult = findMinSubArray(target, mid+1, high);
		
		Result midResult = findMinSubArrayWithMid(target, low, high, mid);
		
		if (leftResult.getSum() > rightResult.getSum() 
			&& leftResult.getSum() > midResult.getSum()) {
			return leftResult;
		}
		
		if (rightResult.getSum() > leftResult.getSum()
			&& rightResult.getSum() > midResult.getSum()) {
			return rightResult;
		}
		
		return midResult;
	}
	
	private static Result findMinSubArrayWithMid(int[] target, int low, int high, int mid) {
		
		int max_left = mid;
		int max_left_sum = Integer.MIN_VALUE;
		
		int sum = 0;
		for (int i = mid; i >= low; --i) {
			sum += target[i];
			if (sum > max_left_sum) {
				max_left = i;
				max_left_sum = sum;
			}
		}
		
		int max_right = mid + 1;
		int max_right_sum = Integer.MIN_VALUE;
		sum = 0;
		for (int i = mid + 1; i <= high; ++i) {
			sum += target[i];
			if (sum > max_right_sum) {
				max_right = i;
				max_right_sum = sum;
			}
		}
		
		return new Result(max_left, max_right, max_left_sum + max_right_sum); 
	}
	
}

package max;

/**
 * 数组arr是一个整数数组，求max(arr[i] + arr[i+1] + ... + arr[j])，0<=i<=j<arr.length
 */
public class MaxSubSumI implements Max {

	/**
	 * O(n)
	 */
	public int max(int[] arr) {
		if (arr == null || arr.length < 1) {
			return 0;
		}

		int sum = arr[0];
		int maxSum = Math.max(0, sum);
		for (int i = 1; i < arr.length; i++) {
			sum = Math.max(0, sum + arr[i]);
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}
}

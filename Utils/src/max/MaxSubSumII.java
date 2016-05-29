package max;

public class MaxSubSumII implements Max {

	/**
	 * O(n*lg(n))
	 */
	public int max(int[] arr) {
		if (arr == null) {
			return 0;
		}

		return maxSubSum(arr, 0, arr.length - 1);
	}

	private int maxSubSum(int[] arr, int min, int max) {
		if (min > max) {
			return 0;
		}
		if (min == max) {
			return arr[min] > 0 ? arr[min] : 0;
		}

		int mid = (min + max) / 2;

		// 把数组分为左右两半。最大子数组只有3种情况：在左边、在右边、左右两半都有
		int leftMax = maxSubSum(arr, min, mid);
		int rightMax = maxSubSum(arr, mid + 1, max);
		int midMax = leftMax(arr, min, mid) + rightMax(arr, mid + 1, max);
		return Math.max(leftMax, Math.max(rightMax, midMax));
	}

	private int rightMax(int[] arr, int min, int max) {
		int sum = 0;
		int maxSum = 0;
		while (max >= min) {
			sum += arr[min];
			if (sum > maxSum) {
				maxSum = sum;
			}
			++min;
		}
		return maxSum;
	}

	private int leftMax(int[] arr, int min, int max) {
		int sum = 0;
		int maxSum = 0;
		while (max >= min) {
			sum += arr[max];
			if (sum > maxSum) {
				maxSum = sum;
			}
			--max;
		}
		return maxSum;
	}
}

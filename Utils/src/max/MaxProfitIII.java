package max;

public class MaxProfitIII implements Max {

	/**
	 * O(n*lg(n))
	 */
	public int max(int[] arr) {
		if ((arr == null || arr.length <= 1)) {
			return 0;
		}

		int[] diff = new int[arr.length - 1];
		for (int i = 0; i < diff.length; i++) {
			diff[i] = arr[i + 1] - arr[i];
		}
		return new MaxSubSumII().max(diff);
	}

}

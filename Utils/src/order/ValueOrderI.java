package order;

import util.Util;

/**
 * 找出数组中第i小的元素(1<=i<=n)
 */
public class ValueOrderI implements Order {

	@Override
	public int order(int[] arr, int order) {
		if (arr == null || arr.length == 0 || order < 1 || order > arr.length) {
			return 0;
		}
		return randomOrder(arr, 0, arr.length - 1, order);
	}

	private int randomOrder(int[] arr, int min, int max, int order) {
		if (min == max) {
			return arr[min];
		}

		int mid = Util.partition(arr, min, max);
		int seq = mid - min + 1;
		if (seq == order) {
			return arr[mid];
		} else if (seq < order) {
			return randomOrder(arr, mid + 1, max, order - seq);
		} else {
			return randomOrder(arr, min, mid - 1, order);
		}
	}
}

package util;

public class Util {

	public static int[] createRandomArr(int amount) {
		return createRandomArr(amount, 100000000);
	}

	public static int[] createRandomArr(int amount, int maxNumber) {
		if (amount < 0) {
			return null;
		}
		int[] arr = new int[amount];
		for (int i = 0; i < amount; i++) {
			arr[i] = (int) (Math.random() * maxNumber);
		}
		return arr;
	}

	public static boolean isEquals(int[] arr1, int[] arr2) {
		if (arr1 == null) {
			return arr2 == null;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	public static String formatInteger(int num) {
		if (num < 0) {
			return "" + num;
		}
		String s = "" + num;
		String result = "";
		int pos = s.length() - 3;
		while (pos > 0) {
			result = "," + s.substring(pos, pos + 3) + result;
			pos -= 3;
		}
		result = s.substring(0, pos + 3) + result;
		return result;
	}

	public static int min(int[] arr, int size) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < size; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}

	public static int max(int[] arr, int size) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < size; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	public static int max(int[] arr) {
		return max(arr, arr.length);
	}

	public static int partition(int[] arr, int min, int max) {
		int randomPos = min + (int) (Math.random() * (max - min + 1));
		swap(arr, min, randomPos);
		int val = arr[min];
		int left = min + 1;
		int right = max;
		while (left <= right) {
			while (left <= right && arr[left] <= val) {
				++left;
			}
			while (left <= right && arr[right] > val) {
				--right;
			}
			if (left <= right) {
				swap(arr, left, right);
			}
		}
		swap(arr, min, left - 1);
		return left - 1;
	}

	public static void swap(int[] arr, int i, int j) {
		int val = arr[i];
		arr[i] = arr[j];
		arr[j] = val;
	}
}

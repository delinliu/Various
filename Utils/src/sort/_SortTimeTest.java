package sort;

import java.util.ArrayList;
import java.util.List;

public class _SortTimeTest {

	public static void main(String[] args) {

		long maxTime = 300;
		int maxAmount = 100000000;

		List<Sort> list = new ArrayList<Sort>();
		list.add(new InsertionSort());
		list.add(new SelectionSort());
		list.add(new BubbleSort());
		list.add(new MergeSort());
		list.add(new MergeNoRecursionSort());

		for (Sort sort : list) {
			sortTime(sort, maxTime, maxAmount);
		}

	}

	public static void sortTime(Sort s, long maxTime, int maxAmount) {

		int amount = 10000;
		long time = 0;

		while (amount < maxAmount && time < maxTime) {
			time = sortTime(s, amount);
			amount *= 10;
		}
		System.out.println(s.getClass() + " costs " + (time)
				+ "ms for sorting " + formatInteger(amount) + " numbers.");
	}

	private static long sortTime(Sort s, int amount) {
		long time;
		int[] arr = _SortTest.createRandomArr(amount);
		int[] arrCopy = arr.clone();
		long begin = System.currentTimeMillis();
		s.sort(arrCopy);
		long end = System.currentTimeMillis();
		time = end - begin;
		return time;
	}

	private static String formatInteger(int num) {
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
}

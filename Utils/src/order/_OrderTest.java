package order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.Util;

public class _OrderTest {

	public static void main(String[] args) {

		int amount = 10000;
		int[] arr = Util.createRandomArr(amount);
		int[] arrSorted = arr.clone();
		Arrays.sort(arrSorted);

		List<Order> list = new ArrayList<Order>();
		list.add(new ValueOrderI());
		list.add(new ValueOrderII());
		f1: for (Order order : list) {
			for (int i = 0; i < amount; i += Math.random() * 100) {
				int[] arrCopy = arr.clone();
				int val = order.order(arrCopy, i + 1);
				int val2 = arrSorted[i];
				if (val != val2) {
					System.err.println("" + order.getClass() + " is wrong.");
					continue f1;
				}
			}
			System.out.println("" + order.getClass() + " is right.");
		}
	}
}

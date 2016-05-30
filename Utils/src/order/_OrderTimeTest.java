package order;

import java.util.ArrayList;
import java.util.List;

import util.Util;

public class _OrderTimeTest {

	public static void main(String[] args) {

		int amount = 10000000;
		int[] arr = Util.createRandomArr(amount);

		List<Order> list = new ArrayList<Order>();
		list.add(new ValueOrderI());
		list.add(new ValueOrderII());

		for (Order order : list) {
			int[] arrCopy = arr.clone();
			long begin = System.currentTimeMillis();
			order.order(arrCopy, amount / 2);
			long end = System.currentTimeMillis();
			System.out.println("" + order.getClass() + " costs "
					+ (end - begin) + "ms for " + Util.formatInteger(amount)
					+ " length array.");
		}
	}
}

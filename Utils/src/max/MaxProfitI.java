package max;

/**
 * 数组arr记录着一只股票在一段时间内的价格，能够买入与卖出一次，求最大利润。
 */
public class MaxProfitI implements Max {

	/**
	 * O(n)
	 */
	public int max(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return 0;
		}

		// 第i天卖出的最大利润是arr[i]-lowestPrice(0~i-1)
		int lowestPrice = arr[0];
		int maxProfit = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - lowestPrice > maxProfit) {
				maxProfit = arr[i] - lowestPrice;
			}
			if (arr[i] < lowestPrice) {
				lowestPrice = arr[i];
			}
		}
		return maxProfit;
	}
}

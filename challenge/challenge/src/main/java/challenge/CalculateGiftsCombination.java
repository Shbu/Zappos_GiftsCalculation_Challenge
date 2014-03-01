package challenge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CalculateGiftsCombination {

	private static final int TOTAL_PRODUCTS_REQUIRED = 5;
	private FinalOutputBean finalOutputBean = null;

	List<Object> finalListOfProducts = new ArrayList<Object>();

	public CalculateGiftsCombination(FinalOutputBean finalOutputBean) {
		super();
		this.finalOutputBean = finalOutputBean;
	}

	@SuppressWarnings("null")
	public List<Results> removeProductsGreaterThanGivenPrice(int productsCount,
			float price) {

		List<Results> resultsList = finalOutputBean.getResults();
		System.out.println("Total results" + resultsList.size());

		Iterator<Results> resultsIterator = resultsList.iterator();
		List<String> priceList = null;
		List<String> productName = null;
		int count = 1;
		while (resultsIterator.hasNext()) {
			Results results = resultsIterator.next();
			if (Float.parseFloat(results.getPrice().substring(1)) < price) {
				System.out.println("ProductName" + results.getProductName()
						+ "| Price" + results.getPrice());
				priceList = new ArrayList<String>();
				productName = new ArrayList<String>();
				priceList.add(results.getPrice());
				productName.add(results.getProductName());
			} else {
				resultsIterator.remove();
				System.out.println("Product" + count + "Missed");
			}
			count++;
		}
		System.out.println("Total Results after calculation: "
				+ resultsList.size());
		Iterator<Results> resultsIteratorOutput = resultsList.iterator();

		while (resultsIteratorOutput.hasNext()) {
			System.out.println("Final products");
			System.out.println(resultsIteratorOutput.next().getProductName());
		}

		ArrayList<BridgeBean> arr = new ArrayList<BridgeBean>(
				TOTAL_PRODUCTS_REQUIRED);
		for (int i = 0; i < TOTAL_PRODUCTS_REQUIRED; i++) {
			arr.add(i, new BridgeBean());
		}
		loop(resultsList, TOTAL_PRODUCTS_REQUIRED, 0, arr, price);
		return resultsList;

	}

	private void loop(List<Results> resultsListnew, int len, int startpoint,
			List<BridgeBean> resultsOutput, float price) {
		System.out.println("--Products Combination for the given budget--");
		if (len == 0) {
			// List<BridgeBean> newFinalBridgeBean = new
			// ArrayList<BridgeBean>();
			float totalPriceOfProducts = 0;
			String productNames = "";
			int productCount = 1;
			for (int i = 0; i < resultsOutput.size(); i++) {
				BridgeBean res = resultsOutput.get(i);
				totalPriceOfProducts += Float.parseFloat(res.getPrice()
						.substring(1));
				productNames += productCount + ": " + res.getProductName()
						+ "\n";
				productCount++;
				// System.out.println(res.getProductName());
			}

			if (totalPriceOfProducts < price) {
				System.out.println("Combination No: " + productCount);
				System.out.println(productNames);
				System.out.println("Total price for above products: "
						+ totalPriceOfProducts + "\n"
						+ "-----------------------------");
			}

			// System.out.println("finalListOfProducts :---"
			// +finalListOfProducts.size());
			return;
		}

		for (int i = startpoint; i <= (resultsListnew.size() - len); i++) {
			// resultsOutput.add(resultsListnew.get(i));
			resultsOutput.get(resultsOutput.size() - len).setProductName(
					resultsListnew.get(i).getProductName());
			resultsOutput.get(resultsOutput.size() - len).setPrice(
					resultsListnew.get(i).getPrice());
			// System.out.println("ProductName"
			// +resultsOutput.get(resultsOutput.size()-len).getProductName()
			// +"\t Price:"
			// +resultsOutput.get(resultsOutput.size()-len).getPrice());
			loop(resultsListnew, len - 1, i + 1, resultsOutput, price);
		}
	}

}

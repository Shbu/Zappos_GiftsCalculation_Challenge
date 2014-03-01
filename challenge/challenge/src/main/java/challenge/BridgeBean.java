package challenge;

import java.io.Serializable;

public class BridgeBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3736141155963476645L;
	private String price;
	private String productName;
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BridgeBean(){
		
	}
	
	
	
}


public class Product 
{
	int ItemCode;
	String ItemName;
	int ItemRate;
	int ItemQuantity;

	public Product(int itemCode, String itemName, int itemRate, int itemQuantity) {
		super();
		ItemCode = itemCode;
		ItemName = itemName;
		ItemRate = itemRate;
		ItemQuantity = itemQuantity;
	}

	public int getItemCode() {
		return ItemCode;
	}
	public void setItemCode(int itemCode) {
		ItemCode = itemCode;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public int getItemRate() {
		return ItemRate;
	}
	public void setItemRate(int itemRate) {
		ItemRate = itemRate;
	}
	public int getItemQuantity() {
		return ItemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		ItemQuantity = itemQuantity;
	}

}

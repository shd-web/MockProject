package dto;

public class ItemsDTO {
	private int itemId;
	private int itemName;
	private int categoryId;
	private int colorId;
	private int price;
	private int manufacture;

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemName(int itemName) {
		this.itemName = itemName;
	}

	public int getItemName() {
		return itemName;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public int getColorId() {
		return colorId;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setManufacture(int manufacture) {
		this.manufacture = manufacture;
	}

	public int getManufacture() {
		return manufacture;
	}
}

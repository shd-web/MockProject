package dto;

public class ItemsDTO {
	private int itemId;
	private String itemName;
	private int categoryId;
	private String categoryName;
	private int colorId;
	private String colorName;
	private int price;
	private String manufacture;

	//商品IDのセッターとゲッター
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemId() {
		return itemId;
	}

	//商品名のセッターとゲッター
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemName() {
		return itemName;
	}

	//カテゴリIDのセッターとゲッター
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	//カテゴリ名のセッターとゲッター
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	//色IDのセッターとゲッター
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public int getColorId() {
		return colorId;
	}

	//色名のセッターとゲッター
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getColorName() {
		return colorName;
	}

	//値段のセッターとゲッター
	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
	//製造者のセッターとゲッター
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getManufacture() {
		return manufacture;
	}
}

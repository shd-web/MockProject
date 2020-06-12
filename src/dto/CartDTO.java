
package dto;

import java.io.Serializable;

//cartテーブルではなく、カート一覧のページに表示したいものが入っている
public class CartDTO implements Serializable{

	private int itemId;
	private String itemName;
	private String colorName;
	private int quantity;
	private String manufacturer;
	private int price;
	private int stock;

	//商品IDのセッター
	public void setItemId(int itemId) {
			this.itemId = itemId;
	}

	//商品IDのゲッター
	public int getItemId() {
		return itemId;
	}

	//商品名のセッター
	public void setItemName(String itemName) {
		this.itemName= itemName;
	}

	//商品名のゲッター
	public String getItemName() {
	return itemName;
	}

	//色名のセッター
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	//色名のゲッター
	public String getColorName() {
		return colorName;
	}

	//数量のセッター
	public void setQuantity(int quantity) {
			this.quantity = quantity;
	}

	//数量のゲッター
	public int getQuantity() {
		return quantity;
	}

	//製造者のセッター
	public void setManufacturer(String manufacturer) {
		this.manufacturer= manufacturer;
	}

	//製造者のゲッター
	public String getManufacturer() {
	return manufacturer;
	}

	//値段のセッター
	public void setPrice(int price) {
			this.price = price;
	}

	//値段のゲッター
	public int getPrice() {
		return price;
	}

	//在庫のセッター
	public void setStock(int stock) {
			this.stock = stock;
	}

	//在庫のゲッター
	public int getStock() {
		return stock;
	}
}

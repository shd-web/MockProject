package dto;

import java.util.Date;

public class ItemsStockDTO {
	private int itemId;
	private int colorId;
	private int stock;
	private Date updateDate;

	//商品IDのセッター
	public void setItemId(int itemId) {
		this.itemId= itemId;
	}

	//商品IDのゲッター
	public int getItemName() {
		return itemId;
	}

	//色IDのセッター
	public void setColorId(int colorId) {
		this.colorId= colorId;
	}

	//色IDのゲッター
	public int getColorId() {
		return colorId;
	}

	//在庫のセッター
	public void setStock(int stock) {
		this.stock= stock;
	}

	//在庫のゲッター
	public int getStock() {
		return stock;
	}

	//更新日のセッター
	public void setUpdateDate(Date updateDate) {
		this.updateDate= updateDate;
	}

	//更新日のゲッター
	public Date getUpdateDate() {
		return updateDate;
	}
}

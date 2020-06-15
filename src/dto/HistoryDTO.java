package dto;

import java.sql.Date;

public class HistoryDTO {

	private int historyId;
	private int itemId;
	private Date purchaseDate;


	//historyIDのセッターとゲッター
	public void setHistoryId(int historyId) {
			this.historyId = historyId;
	}

	public int getHistoryId() {
		return historyId;
	}

	//商品IDのセッターとゲッター
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemId() {
		return itemId;
	}
	//購入日のセッターとゲッター
	public void setPurchaseDate(Date purchaseDate) {
			this.purchaseDate = purchaseDate;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

}

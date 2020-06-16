package dto;

import java.sql.Date;

public class HistoryDTO {

	private int historyId;
	private String accountId;
	private String otherAddress;
	private Date purchaseDate;

	//historyIDのセッターとゲッター
	public void setHistoryId(int historyId) {
			this.historyId = historyId;
	}

	public int getHistoryId() {
		return historyId;
	}

	//accountIDのセッターとゲッター
	public void setAccountId(String accountId) {
			this.accountId = accountId;
	}

	public String getAccountId() {
		return accountId;
	}

	//別送住所のセッターとゲッター
	public void setOtherAddress(String otherAddress) {
			this.otherAddress = otherAddress;
	}

	public String getOtherAddress() {
		return otherAddress;
	}

	//購入日のセッターとゲッター
	public void setPurchaseDate(Date purchaseDate) {
			this.purchaseDate = purchaseDate;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}
}

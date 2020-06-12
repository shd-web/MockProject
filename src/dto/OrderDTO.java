package dto;

public class OrderDTO {

	private int accountId;
	private String accountName;
	private String address;

	//アカウントIDのセッター
	public void setAccountId(int accountId) {
			this.accountId = accountId;
	}

	//アカウントIDのゲッター
	public int getAccountId() {
		return accountId;
	}

	//アカウント名のセッター
	public void setAccountName(String accountName) {
		this.accountName= accountName;
	}

	//アカウント名のゲッター
	public String getAccountName() {
	return accountName;
	}

	//アドレスのセッター
	public void setAddress(String address) {
		this.address= address;
	}

	//アドレスのゲッター
	public String getAddress() {
	return address;
	}

}

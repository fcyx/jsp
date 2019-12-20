package java_bean;

public class order_bean {
	String ClotheName;
	String clotheImg;
	int OrderId;
	String Name;
	String UserName;
	int ClotheId;
	double Clotheprice;
	int ClotheNumber;
	String ClotherSize;
	double TotalMoney;
	String OrderDate;
	String address;
	String post;
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public int getClotheId() {
		return ClotheId;
	}
	public void setClotheId(int clotheId) {
		ClotheId = clotheId;
	}
	public double getClotheprice() {
		return Clotheprice;
	}
	public void setClotheprice(double clotheprice) {
		Clotheprice = clotheprice;
	}
	public int getClotheNumber() {
		return ClotheNumber;
	}
	public void setClotheNumber(int clotheNumber) {
		ClotheNumber = clotheNumber;
	}
	public String getClotherSize() {
		return ClotherSize;
	}
	public void setClotherSize(String clotherSize) {
		ClotherSize = clotherSize;
	}
	public double getTotalMoney() {
		return TotalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		TotalMoney = totalMoney;
	}
	public String getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getClotheImg() {
		return clotheImg;
	}
	public void setClotheImg(String clotheImg) {
		this.clotheImg = clotheImg;
	}
	public String getClotheName() {
		return ClotheName;
	}
	public void setClotheName(String clotheName) {
		ClotheName = clotheName;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
}

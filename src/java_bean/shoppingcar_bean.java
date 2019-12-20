package java_bean;

import java.io.Serializable;

public class shoppingcar_bean implements Serializable{
	int ShoppingcarID;
	String UserName;
	int ClotheId;
	int ClotheNumber;
	String ClotheName;
	String ClotheSize;
	double ClothePrice;
	String Clothetype;
	String ClotheImg;
	public int getShoppingcarID() {
		return ShoppingcarID;
	}
	public void setShoppingcarID(int shoppingcarID) {
		ShoppingcarID = shoppingcarID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public int getClotheNumber() {
		return ClotheNumber;
	}
	public void setClotheNumber(int clotheNumber) {
		ClotheNumber = clotheNumber;
	}
	public String getClotheName() {
		return ClotheName;
	}
	public void setClotheName(String clotheName) {
		ClotheName = clotheName;
	}
	public String getClotheSize() {
		return ClotheSize;
	}
	public void setClotheSize(String clotheSize) {
		ClotheSize = clotheSize;
	}
	public double getClothePrice() {
		return ClothePrice;
	}
	public void setClothePrice(double clothePrice) {
		ClothePrice = clothePrice;
	}
	public String getClothetype() {
		return Clothetype;
	}
	public void setClothetype(String clothetype) {
		Clothetype = clothetype;
	}
	public String getClotheImg() {
		return ClotheImg;
	}
	public void setClotheImg(String clotheImg) {
		ClotheImg = clotheImg;
	}
	public int getClotheId() {
		return ClotheId;
	}
	public void setClotheId(int clotheId) {
		ClotheId = clotheId;
	}

}

package by.htp.flowers.bean;

public class Ribbon extends Price {
	
	private String color;
	private int lenght;
//	private double price;
	
	public Ribbon() {
		super();
	}
	
	public Ribbon (String color, int lenght, double price) {
		 this.color = color;
		 this.lenght = lenght;
		 super.setPrice(price);
	//	 this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getLenght() {
		return lenght;
	}
	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public double getPrice() {
		return super.getPrice();
	}

	public void setPrice(double price) {
		super.setPrice(price);
	}
	
	

}

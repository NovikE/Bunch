package flowers.bean;

public class Ribbon extends Price {
	private int id;
	private String color;
	private int length;

	public Ribbon() {
		super();
	}
	
	public Ribbon (int id, String color, int length, double price) {
		 this.id = id;
		 this.color = color;
		 this.length = length;
		 super.setPrice(price);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getLength() {return length;	}
	public void setLength(int length) {
		this.length = length;
	}

	public double getPrice() {
		return super.getPrice();
	}

	public void setPrice(double price) {
		super.setPrice(price);
	}
	
	

}

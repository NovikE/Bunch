package by.htp.flowers.bean;

public class Flower extends Price {
	private String title;
	private Stem stem;
	// private double price;
	private int freshness;

	public Flower(String title, int stemh, int stemw, double price, int freshness) {

		this.title = title;
		stem = new Stem(stemh, stemw);
		super.setPrice(price);
		this.freshness = freshness;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Stem getStem() {
		return stem;
	}

	public void setStem(Stem stem) {
		this.stem = stem;
	}

	public double getPrice() {
		return super.getPrice();
	}

	public void setPrice(double price) {
		super.setPrice(price);
	}

	public int getFreshness() {
		return freshness;
	}

	public void setPriceFreshness(int freshness) {
		this.freshness = freshness;
	}

}

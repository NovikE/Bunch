package flowers.bean;

import flowers.exceptions.MyExceptionNegVal;

public class Flower extends Price {

	private int id;
	private String title;
	private Stem stem;
	private int freshness;
	private int quantity;

	public Flower (){}

	public Flower(int id, String title, int stemh, int stemw, double price, int freshness, int quantity) {
		this.id = id;
		this.title = title;
		stem = new Stem(stemh, stemw);
		super.setPrice(price);
		this.freshness = freshness;
		this.quantity = quantity;

	}

	public int getId(){return id;};

	public void setId(int id) {this.id = id;};

	public int getQuantity() {return quantity;}

	public void setQuantity(int quantity) throws MyExceptionNegVal{

			if (quantity < 0) {
			throw new MyExceptionNegVal("Negative value is not expected!");
		}
		this.quantity = quantity;
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

	public void setFreshness(int freshness) {
		this.freshness = freshness;
	}

	@Override
	public String toString() {
		return (id +	" " + title + " " + stem.getHeight() + " " + stem.getWidth() + " " + getPrice() + " " + freshness +
				" " + quantity);
	}
}

package by.htp.flowers.bean;

import java.util.ArrayList;
import java.util.Iterator;

public class Bunch {

	private ArrayList<Flower> flowers = new ArrayList<Flower>();
	private Ribbon ribbon;

	public Bunch(ArrayList<Flower> flowers, Ribbon ribbon) {
		this.flowers = flowers;
		this.ribbon = ribbon;
	}

	public ArrayList<Flower> getFlowers() {
		return flowers;
	}

	public void setFlowers(ArrayList<Flower> flowers) {
		this.flowers = flowers;
	}

	public Ribbon getRibbon() {
		return ribbon;
	}

	public void setRibbon(Ribbon ribbon) {
		this.ribbon = ribbon;
	}

	public double sumBrunch() {

		Iterator<Flower> it = flowers.iterator();
		double sum = 0.0;
		while (it.hasNext()) {
			Flower current = it.next();
			sum = sum + current.getPrice();
		}

		sum = sum + ribbon.getPrice();

		return sum;
	}

	public void findFlower(int heightMin, int heightMax) {

		Iterator<Flower> it = flowers.iterator();
		while (it.hasNext()) {
			Flower current = it.next();
			if ((heightMin < current.getStem().getHeight()) & (current.getStem().getHeight() < heightMax)) {

				System.out.println("Flower with neseccary stem's height: " + current.getTitle() + ". Stem's height: "
						+ current.getStem().getHeight() + ".");

			}

		}

	}

	public void sortFlowersByFresh() {

		Flower current;
		boolean f = true;
		for (int i = 0; i < flowers.size(); i++) {
			for (int j = 0; j < ((flowers.size() - 1) - i); j++) {
				if (flowers.get(j).getFreshness() > flowers.get(j + 1).getFreshness()) {
					current = flowers.get(j);
					flowers.remove(j);
					flowers.add(j + 1, current);
					f = true;
				} else {
					f = false;
				}

			}
			if (f == false) {
				break;
			}
		}

	}

}

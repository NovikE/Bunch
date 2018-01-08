package by.htp.flowers.runner;

import java.util.ArrayList;

import by.htp.flowers.bean.Bunch;
import by.htp.flowers.bean.Flower;
import by.htp.flowers.bean.Ribbon;
import by.htp.flowers.logic.BunchInfo;

public class Main {

	public static void main(String[] args) {

		Flower flower = new Flower("Cammomile", 10, 1, 3.3, 1);
		Flower flower1 = new Flower("Rose", 25, 1, 10.4, 0);
		Flower flower2 = new Flower("Tulip", 7, 1, 7.6, 3);
		Flower flower3 = new Flower("Pink", 17, 1, 8.8, 5);
		Flower flower4 = new Flower("Rose", 40, 1, 28.8, 3);

		ArrayList<Flower> flowers = new ArrayList<Flower>();
		flowers.add(flower);
		flowers.add(flower1);
		flowers.add(flower2);
		flowers.add(flower3);
		flowers.add(flower4);
		
		Ribbon ribbon = new Ribbon("blue", 30, 1.5);

		Bunch bunch = new Bunch(flowers, ribbon);

		System.out.println(bunch.sumBrunch());

		bunch.findFlower(9, 26);

		bunch.sortFlowersByFresh();

		BunchInfo prnt = new BunchInfo();
		prnt.printBunchInfo(bunch);

	}

}

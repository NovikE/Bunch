package by.htp.flowers.logic;

import java.util.ArrayList;
import java.util.Iterator;

import by.htp.flowers.bean.Bunch;
import by.htp.flowers.bean.Flower;

public class BunchInfo {
	public void printBunchInfo(Bunch bunch) {
		
		Iterator<Flower> it = bunch.getFlowers().iterator();
		while (it.hasNext()) {
			Flower current = it.next();
			System.out.println(current.getTitle() + ": freshess is " 
						+ current.getFreshness() + " days.");		
		}
		
		System.out.println("Color of ribbon: " + bunch.getRibbon().getColor() + 
				". Lenght of ribbon: " + bunch.getRibbon().getLenght());
		
	}
}

package flowers.logic;

import java.util.List;
import java.util.Iterator;
import java.util.Map;

import flowers.bean.Bunch;
import flowers.bean.Flower;

public class BunchInfo {
	public void printBunchInfo(Bunch bunch, List<Flower> flowers) {

		Iterator<Map.Entry<Integer, Integer>> it = bunch.getRequest().entrySet().iterator();
		double sum = 0.0;
		while (it.hasNext()) {
			//Flower current = it.next();
			Map.Entry<Integer,Integer> entry = it.next();
			try {
				for (Flower fl: flowers
				) {
					if ((fl.getId() == entry.getKey()) && (entry.getValue() > 0)){
						System.out.println(fl.getTitle() + ": freshess is "
								+ fl.getFreshness() + " days." + " Price: " + fl.getPrice() + " BYN");
					}
				}
			}catch (NullPointerException e){
				System.out.println("Something is wrong!");
			}
		}
		

	}
}

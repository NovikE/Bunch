package flowers.bean;

import java.util.*;

public class Bunch {

	private int id;
	private Map<Integer, Integer> request = new HashMap<Integer,Integer>();
	private int ribbonId;

	public Bunch (){

	}

	public Bunch(int id, Map<Integer, Integer> request, int ribbonId) {
		this.id = id;
		this.request = request;
		this.ribbonId = ribbonId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Map<Integer, Integer> getRequest() {
		return request;
	}

	public void setRequest(Map<Integer, Integer> request) {
		this.request = request;
	}

	public int getRibbonId() {
		return ribbonId;
	}

	public void setRibbonId(int ribbonId) {
		this.ribbonId = ribbonId;
	}

	public double sumBrunch(List<Flower> flowers, List<Ribbon> ribbons) {

		Iterator<Map.Entry<Integer, Integer>> it = request.entrySet().iterator();
		double sum = 0.0;
		while (it.hasNext()) {
			Map.Entry<Integer,Integer> entry = it.next();
			try {
				for (Flower fl: flowers
					 ) {
					if (fl.getId() == entry.getKey()){
					sum = sum + fl.getPrice()*entry.getValue();
					}
				}
			}catch (NullPointerException e){
				System.out.println("Something is wrong!");
			}
		}

		for(Ribbon rb: ribbons){
			if(rb.getId() == ribbonId){
				sum = sum + rb.getPrice();
			}
		}
		return sum;
	}


}

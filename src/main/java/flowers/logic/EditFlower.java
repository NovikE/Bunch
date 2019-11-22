package flowers.logic;

import flowers.bean.Bunch;
import flowers.bean.Flower;
import flowers.exceptions.MyExceptionNegVal;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EditFlower {
    public void editQuantity(Bunch bunch, List<Flower> flowers) {
          Iterator<Map.Entry<Integer, Integer>> it = bunch.getRequest().entrySet().iterator();
          while (it.hasNext()) {
            Map.Entry<Integer,Integer> entry = it.next();
            try {
                for (Flower fl: flowers
                ) {
                    if (fl.getId() == entry.getKey()){
                        try {
                            fl.setQuantity((fl.getQuantity() - entry.getValue()));
                        }catch(MyExceptionNegVal e){
                            e.getMessage();
                        }
                    }
                }
                }catch (NullPointerException e){
                System.out.println("Something is wrong!");
            }
        }
    }


}

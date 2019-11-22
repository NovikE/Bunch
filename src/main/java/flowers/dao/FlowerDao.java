package flowers.dao;

import flowers.bean.Flower;

import java.util.List;

public interface FlowerDao extends BaseDao<Flower> {

    List<Flower> readAll();
}

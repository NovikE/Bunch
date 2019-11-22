package flowers.dao;

public interface BaseDao <T>{

    void create(T entity);
    T read(int id);
    void update(T entity);
    void delete(int id);

}

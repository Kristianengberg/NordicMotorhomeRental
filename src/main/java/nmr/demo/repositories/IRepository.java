package nmr.demo.repositories;

import java.util.List;

public interface IRepository<T> {
    // CRUD operations
    public boolean create(T model);
    public T read(int id);
    public List<T> readAll();
    public boolean update(T model);
    public boolean delete(int id);

}

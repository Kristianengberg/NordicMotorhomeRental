package nmr.demo.repositories;

import java.util.List;

public interface InterfaceRepository {

    // CRUD operations
    public boolean create(Object model);

    public Object read(int id);

    public List<Object> readAll();

    public boolean update(Object student);

    public boolean delete(int id);
}

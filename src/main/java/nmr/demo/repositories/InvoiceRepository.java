package nmr.demo.repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository implements InterfaceRepository {
    @Override
    public boolean create(Object model) {
        return false;
    }

    @Override
    public Object read(int id) {
        return null;
    }

    @Override
    public List<Object> readAll() {
        return null;
    }

    @Override
    public boolean update(Object student) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}

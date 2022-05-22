package za.ac.cput.repository;

import java.sql.SQLException;

public interface IRepository<T,ID> {
    T create(T t) throws SQLException, ClassNotFoundException;
    T read(ID id) throws SQLException;
    T update(T t) throws SQLException;
    boolean delete(ID id) throws SQLException;
}

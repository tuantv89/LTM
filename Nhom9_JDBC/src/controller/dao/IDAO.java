package controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class IDAO<T> {

    Statement statement;
    PreparedStatement preStatement;
    Connection conn;
    ResultSet rs;

    public abstract T[] selectAll();

    public abstract T[] selectByName(String name);

    public abstract int insert(T object);

    public abstract int update(T object);

    public abstract void closeConnection();
}

package com.finance.connectors.jdbc;


import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interface for JDBC connection.
 */
public interface JdbcSourceConnection {

    Connection getConnection() throws SQLException;
}

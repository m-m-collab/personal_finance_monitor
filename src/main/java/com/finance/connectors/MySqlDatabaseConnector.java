package com.finance.connectors;

import com.finance.connectors.jdbc.JdbcSourceConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class MySqlDatabaseConnector implements JdbcSourceConnection {

    private String url;
    private String user;
    private String password;

    @Override
    public Connection getConnection() throws SQLException {
        return null;
    }
}

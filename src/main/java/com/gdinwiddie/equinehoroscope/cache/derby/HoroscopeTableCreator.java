package com.gdinwiddie.equinehoroscope.cache.derby;

import java.sql.Connection;
import java.sql.SQLException;

import com.idiacomputing.jdbc.JdbcWriter;

public class HoroscopeTableCreator extends JdbcWriter {

    private final ConnectionFactory connectionFactory;

    HoroscopeTableCreator(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    protected Connection fetchConnection() throws SQLException {
        return connectionFactory.getConnection();
    }

    @Override
    protected String fetchInsertStatement() {
        return "Create table Horoscopes ( "
                + "HORSENAME		VARCHAR  (40)  NOT NULL, "
                + "EFFECTIVE_DATE   VARCHAR  (40)  NOT NULL, "
                + "HOROSCOPE		VARCHAR  (1024)  NOT NULL " + ")";
    }

    void createTable() throws SQLException {
        writeDb();
    }

}

package com.example;

import java.sql.*;


public class App 
{
    public static void main(String[] args) throws SQLException
    {
        DB1 dbconn = new DB1();
        Connection conn = dbconn.createConnection("test");

        Statement stmt = conn.createStatement();

        // dbconn.retrieveColumnValues(conn, 
        // "SELECT * FROM student", 
        // new String[]{"id", "name", "number"}
        // );

        // dbconn.insertInBatch(conn, "insert into emp (eid, ename) values(?, ?)", new String[] {
        //         "4353", "Mary",
        //         "5392", "Sharon", 
        //         "3921", "Louis",
        // });
        dbconn.createTable(stmt, "");

    }
}

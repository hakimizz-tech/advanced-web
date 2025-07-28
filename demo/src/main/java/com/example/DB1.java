package com.example;

import java.sql.*;

public class DB1 {

    Connection createConnection(String dbname){
        String url  = "jdbc:mysql://localhost:3306/" + dbname;
        String username = "root";
        String password = "";

        Connection conn = null;

        try {
            //loading drivers
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection
            conn =  DriverManager.getConnection(url, username, password);
            System.out.println("connected to the database");

        }
        catch (ClassNotFoundException e) {
            System.out.println(" Driver not found: " + e.getMessage());
        } 
        catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        return conn;
    }

    public void retrieveColumnValues(int num, Connection conn, String query, String[] placeholder, String[] columns) throws SQLException {
        
        if (num == 0){
            Statement stmt = conn.createStatement();
            ResultSet rst = null;

        try {
            rst = stmt.executeQuery(query);

            while (rst.next()) {
                for (String column : columns) {
                    String value = rst.getString(column);
                    System.out.println(column + ": " + value);
                }
                System.out.println("-----------"); // Optional: separator between rows
            }      

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rst != null) rst.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
        }
        
        else if ( num == 1) {
            // use PreparedStatement
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = null;

            try {
                if (query.contains("?")) {
                    //our query is set for the prepared statement
                    int index = 0;

                    for(String ph : placeholder){
                        //increment the index
                        index++;
                        
                        //check if a placeholder is an integer ans set it as Int
                        if(ph.matches("\\d+")) stmt.setInt(index, Integer.parseInt(ph));
                        else stmt.setString(index, ph);
                        
                    }

                    rs = stmt.executeQuery();

                    while(rs.next()){
                        String value = null;
                        for(String c: columns ){
                            value = rs.getString(c);
                            System.out.println(c + " : " + value);
                        }
                        System.out.println("---------------");
                    }
                    
                }
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
}
            
        }
}

public void retrieveColumnValues(Connection conn, String query, String column) {
    retrieveColumnValues(conn, query, new String[]{column});
}

public void retrieveColumnValues(Connection conn, String query, String[] columns) {
    try {
        retrieveColumnValues(0, conn, query, null, columns);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}



public void insertToATable(Statement statement, String query){
    Statement stmt = statement;

    try {
       
        //execureUpdate() is used to UPDATE, DELETE, and INSERT
        //Returns the number of rows affected by the excute statement
        int result = stmt.executeUpdate(query);

        if(result > 0) System.out.println("Updated successfully");
        else  System.out.println("Failed to update");
        


    } catch (SQLException e) {
        // TODO: handle exception
        e.printStackTrace();
    }
}

    public void createTable(Statement statement, String query) throws SQLException {
        String createTableSQL = query;
        statement.executeUpdate(createTableSQL);
        System.out.println("Table created successfully.");
    }

    public void deleteData(Statement statement, String query) throws SQLException{
        if (query.toLowerCase(). contains("delete"))   statement.executeUpdate(query);
        System.out.println("Data deleted successfully");
    }

    public void dropColumn(Statement statement, String query) throws SQLException{
        if(query.toLowerCase().contains("alter")) statement.executeUpdate(query);
        System.out.println("Column dropped successfully");
    }

    public void addColumn(Statement statement, String query) throws SQLException{
        if(query.toLowerCase().contains("alter")) statement.executeUpdate(query);
        System.out.println("Column add successfully");
    }

    public void updateData(Statement statement, String query) throws SQLException{
        if(query.toLowerCase().contains("update")) statement.executeUpdate(query);
        System.out.println("Data updated successfully");
    }

    public void insertInBatch(Statement stmt, String[] query) throws SQLException{
        for(String q : query) stmt.addBatch(q);

        int[] arr = stmt.executeBatch();

        for ( int i : arr) System.out.println(i);

    }

    public void insertInBatch(Connection conn, String query, String[] values) throws SQLException{
        if (query.contains("?")){
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Count the number of ? placeholders
            int questionMarkCount = query.length() - query.replace("?", "").length();
            
            // Validate that we have the right number of values
            if (values.length % questionMarkCount != 0) {
                throw new SQLException("Number of values doesn't match placeholders");
            }
            
            // Calculate how many rows we're inserting
            int rowCount = values.length / questionMarkCount;
            
            // Set parameters for each row
            int valueIndex = 0;
            for (int row = 0; row < rowCount; row++) {
                for (int param = 1; param <= questionMarkCount; param++) {
                    String value = values[valueIndex++];
                    // Check if value is numeric
                    if (value.matches("\\d+")) {
                        pstmt.setInt(param, Integer.parseInt(value));
                    } else {
                        pstmt.setString(param, value);
                    }
                }
                pstmt.addBatch();
            }
            
            // Execute the batch
            int[] results = pstmt.executeBatch();
            
            // Print results
            for (int result : results) {
                System.out.println("Rows affected: " + result);
            }
            
            pstmt.close();
        }
    }

}
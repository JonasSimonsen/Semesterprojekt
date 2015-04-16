/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.InputStream;
import model.Activity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class POE_DAO {
    public void savePOE(int ZIPNO, String filepath) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        String message = null;
        InputStream inputStream = null;
         
        try {
            // connects to the database
            Class.forName(DatabaseInfo.driver);                                 // Henter database driveren.
            connection = DriverManager.getConnection(DatabaseInfo.URL, DatabaseInfo.ID, DatabaseInfo.PW); // Opretter forbindelse til databasen med info fra DB klassen
 
            // constructs SQL statement
            String sql = "INSERT INTO CAMPSTORAGE (ZIPNO, ZIPFILE, CAMPNO) values (?, ?, ?)";
            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setInt(1, ZIPNO);
            prep.setString(2, filepath);
            prep.setBlob(3, inputStream);
            
            prep.executeUpdate();
        
        } finally {
                    prep.close();
                    connection.close();
                    
        }
    }
}

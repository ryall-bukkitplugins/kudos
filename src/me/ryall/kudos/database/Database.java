package me.ryall.kudos.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import me.ryall.kudos.Kudos;

public class Database
{
    private Connection connection;
    
    public Database() throws Exception
    {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:" + Kudos.PLUGIN_NAME + ".db");
    }
    
    public void startup()
    {
        try
        {
            PreparedStatement ps = connection.prepareStatement
            (
                "CREATE TABLE IF NOT EXISTS reputation" +
                "(" +
                    "id INTEGER PRIMARY KEY ASC AUTOINCREMENT, " +
                    "name VARCHAR(100) NULL, " +
                    "score DECIMAL(8, 2) NULL" + 
                ");" +
                "CREATE TABLE IF NOT EXISTS critique" +
                "(" +
                    "id INTEGER PRIMARY KEY ASC AUTOINCREMENT, " +
                    "name VARCHAR(100) NULL, " +
                    "change DECIMAL(8, 2) NULL, " +
                    "comment VARCHAR(300) NULL" +
                ");"
            );
            
            ps.executeUpdate();
        } 
        catch (SQLException ex)
        {
            Kudos.get().getCommunicationManager().logError("Could not initialise the database: " + ex.getMessage());
        }
    }
    
    public void shutdown()
    {
        try
        {
            connection.close();
        } 
        catch (SQLException ex)
        {
            Kudos.get().getCommunicationManager().logError("Could not close the database connection: " + ex.getMessage());
        }
    }
}

package me.ryall.kudos.database;

import org.bukkit.entity.Player;

import me.ryall.kudos.system.Reputation;

public class DatabaseManager
{
    //private Connection connection;
    
    public DatabaseManager()
    {
        /*Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:" + Kudos.PLUGIN_NAME + ".db");*/
    }
    
    public void startup()
    {
        /*try
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
        }*/
    }
    
    public void shutdown()
    {
        /*try
        {
            connection.close();
        } 
        catch (SQLException ex)
        {
            Kudos.get().getCommunicationManager().logError("Could not close the database connection: " + ex.getMessage());
        }*/
    }

    public Reputation getReputation(Player _player)
    {
        return null;
    }
}

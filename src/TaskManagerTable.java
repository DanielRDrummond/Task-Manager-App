
/**
 * Your name: Daniel Drummond
 * Date: 04/21/2024
 * Assignment CIS319 Project - Task Manager App
 * 
 * Class to manage tables in the SQLite database.
 */

 import java.sql.Connection;
 import java.sql.Statement;
 import java.sql.SQLException;
 
public class TaskManagerTable {
    public static boolean createTable(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            // Create the TaskManager table if it doesn't exist
            stmt.execute("CREATE TABLE IF NOT EXISTS TaskManager (title TEXT, description TEXT, deadline TEXT, priority TEXT, status TEXT)");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

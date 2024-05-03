/**
 * Your name: Daniel Drummond
 * Date: 04/21/2024
 * Assignment CIS319 Project - Task Manager App
 * 
 * Description: This class contains the main method to demonstrate the usage of the TaskManager class.
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
 

public class App {
    public static void main(String[] args) {
        final String dbName = "TaskManager.db"; 
        System.out.println("\nDaniel Drummond, Week 4 Database Interactions GP\n");

        // Establish connection to SQLite database
        Connection conn = null;
        try {
            conn = SQLiteDatabase.connect(dbName);
            if (conn != null) {
                // Create table if it doesn't exist
                if (TaskManagerTable.createTable(conn)) { 
                    // Perform CRUD operations
                    // Add tasks
                    TaskManager.addTask(conn, new Task("Complete project", "Finish the project by end of week", "2024-04-15", Priority.HIGH, Status.IN_PROGRESS));
                    TaskManager.addTask(conn, new Task("Buy groceries", "Buy essentials from the supermarket", "2024-04-12", Priority.MEDIUM, Status.PENDING));

                    // Retrieve and print tasks
                    System.out.println("\nAll Tasks in the Database");
                    printTasks(TaskManager.getAllTasks(conn)); 

                    // Update task
                    Task taskToUpdate = new Task("Complete project", "Finish the project by end of week", "2024-04-15", Priority.HIGH, Status.IN_PROGRESS); 
                    TaskManager.updateTask(conn, taskToUpdate);

                    // Delete task
                    TaskManager.deleteTask(conn, taskToUpdate); 

                    // Retrieve and print tasks after update and delete
                    System.out.println("\nAll Tasks in the Database");
                    printTasks(TaskManager.getAllTasks(conn)); 
                }
            }
        } finally {
            // Close connection
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void printTasks(List<Task> tasks) {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
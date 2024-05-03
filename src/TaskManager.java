/**
 * Your name: Daniel Drummond
 * Date: 04/21/2024
 * Assignment CIS319 Project - Task Manager App
 * 
 * Class for managing tasks.
 */

 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.util.ArrayList;
 import java.util.List;


public class TaskManager {
    public static void addTask(Connection conn, Task task) {
        String sql = "INSERT INTO TaskManager(title, description, deadline, priority, status) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, task.getTitle());
            pstmt.setString(2, task.getDescription());
            pstmt.setString(3, task.getDeadline());
            pstmt.setString(4, task.getPriority().toString());
            pstmt.setString(5, task.getStatus().toString());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Task> getAllTasks(Connection conn) {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM TaskManager";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Task task = new Task(
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("deadline"),
                        Priority.valueOf(rs.getString("priority")),
                        Status.valueOf(rs.getString("status"))
                );
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public static void updateTask(Connection conn, Task task) {
        String sql = "UPDATE TaskManager SET description = ?, deadline = ?, priority = ?, status = ? WHERE title = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, task.getDescription());
            pstmt.setString(2, task.getDeadline());
            pstmt.setString(3, task.getPriority().toString());
            pstmt.setString(4, task.getStatus().toString());
            pstmt.setString(5, task.getTitle());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTask(Connection conn, Task task) {
        String sql = "DELETE FROM TaskManager WHERE title = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, task.getTitle());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
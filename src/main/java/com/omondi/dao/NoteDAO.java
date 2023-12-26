package com.omondi.dao;

import java.sql.*;
import java.util.ArrayList;

import com.omondi.model.Note;
import com.omondi.util.ConnectionUtil;

public class NoteDAO {

    public ArrayList<Note> getAllComments() {
        // List to return
        ArrayList<Note> messagesReturned = new ArrayList<>();
        // Create a connection & close connection when done
        try (Connection connection = ConnectionUtil.getConnection();
                // Create statement
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM messages")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String comment = rs.getString("comment");
                String priority = rs.getString("priority");
                Note note = new Note(id, comment, priority);
                messagesReturned.add(note);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return messagesReturned;

    }

    public ArrayList<Note> getCommentsByPriority(String priority) {
        ArrayList<Note> commentsByPriorityReturned = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM messages WHERE priority=?")) {
            ps.setString(1, priority);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String comment = rs.getString("comment");
                String commentPriority = rs.getString("priority");
                Note note = new Note(id, comment, commentPriority);
                commentsByPriorityReturned.add(note);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return commentsByPriorityReturned;

    }

    public boolean deleteCommentById(long id) {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement("DELETE FROM messages WHERE id=?")) {
            ps.setLong(1, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 1) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateCommentById(long id, String comment, String priority) {
        // Create a connection & close connection when done
        try (Connection connection = ConnectionUtil.getConnection();
                // Create statement
                PreparedStatement ps = connection
                        .prepareStatement("UPDATE messages SET comment=?, priority=? WHERE id=?")) {

            ps.setString(1, comment);
            ps.setString(2, priority);
            ps.setLong(3, id);
            // Execute statement
            int rowsAffected = ps.executeUpdate();

            // Process results
            if (rowsAffected == 1) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;

    }

    public Note addComment(String comment, String priority) {
        // Create a connection & close connection when done
        try (Connection connection = ConnectionUtil.getConnection();
                // Create statement
                PreparedStatement ps = connection.prepareStatement(
                        "INSERT INTO messages(comment, priority) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, comment);
            ps.setString(2, priority);

            // Execute statement
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            while (rs.next()) {
                long resultId = rs.getLong(1);
                Note addedNote = new Note(resultId, comment, priority);

                return addedNote;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public Note getCommentById(long id) {
        // Create a connection & close connection when done
        try (Connection connection = ConnectionUtil.getConnection();
                // Create statement
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM messages WHERE id = ?")) {

            ps.setLong(1, id);
            // Execute statement
            ResultSet rs = ps.executeQuery();

            // Process results
            while (rs.next()) {
                long resultId = rs.getLong("id");
                String comment = rs.getString("comment");
                String priority = rs.getString("priority");

                Note noteById = new Note(resultId, comment, priority);
                return noteById;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        return null;

    }
}
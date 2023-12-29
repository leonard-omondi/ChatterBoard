package com.omondi;

import io.javalin.Javalin;

import java.util.List;

import com.omondi.controller.NoteController;
import com.omondi.dao.NoteDAO;
import com.omondi.model.Note;
import com.omondi.util.Database;

public class App {
    public static void main(String[] args) {

        Database.setup();
        NoteController noteController = new NoteController();
        noteController.setup();

        // NoteDAO noteDAO = new NoteDAO();
        // System.out.println(noteDAO.getCommentById(4));

        // noteDAO.updateCommentById(7, "Study session begins promptly at 7 p.m. ",
        // "Low");
        // noteDAO.deleteCommentById(9);

        // List<Note> getAllComments = noteDAO.getAllComments();
        // for (Note comment : getAllComments) {
        // System.out.println("ID=" + comment.getId() + " |Comment=" +
        // comment.getComment() + " |Priority="
        // + comment.getPriority());
        // }
        // System.out.println("-------------------------");
        // List<Note> getCommentsByPriority = noteDAO.getCommentsByPriority("Low");
        // for (Note comment : getCommentsByPriority) {
        // System.out.println("ID=" + comment.getId() + " |Comment=" +
        // comment.getComment() + " |Priority="
        // + comment.getPriority());
        // }
        // NoteDAO noteDAO = new NoteDAO();
        // noteDAO.updateCommentPriorityById(6, "Medium");

    }
}

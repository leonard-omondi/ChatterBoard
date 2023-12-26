package com.omondi;

import java.util.List;

import com.omondi.dao.NoteDAO;
import com.omondi.model.Note;

public class App {
    public static void main(String[] args) {

        NoteDAO noteDAO = new NoteDAO();
        System.out.println(noteDAO.getCommentById(4));

        noteDAO.updateCommentById(7, "Study session begins promptly at 7 p.m. ", "Low");
        noteDAO.deleteCommentById(9);

        List<Note> getAllComments = noteDAO.getAllComments();
        for (Note comment : getAllComments) {
            System.out.println("ID=" + comment.getId() + " |Comment=" + comment.getComment() + " |Priority="
                    + comment.getPriority());
        }
        System.out.println("-------------------------");
        List<Note> getCommentsByPriority = noteDAO.getCommentsByPriority("Low");
        for (Note comment : getCommentsByPriority) {
            System.out.println("ID=" + comment.getId() + " |Comment=" + comment.getComment() + " |Priority="
                    + comment.getPriority());
        }

    }
}
/*
 * import io.javalin.Javalin;
 * Database.setup();
 * Javalin app = Javalin.create().start(9000);
 * 
 * noteDAO.addNote(
 * "Lost my notes from last week's lecture on special relativity. Can anyone share theirs or summarize the key points?"
 * ,
 * "High");
 * 
 */
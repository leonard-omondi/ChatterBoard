package com.omondi.service;

import java.util.ArrayList;

import com.omondi.dao.NoteDAO;
import com.omondi.model.Note;

public class NoteService {

    private NoteDAO noteDAO;

    public NoteService() {
        this.noteDAO = new NoteDAO();
    }

    public Note addMessage(Note commentToAdd) {
        return noteDAO.addComment(commentToAdd.getContent(), commentToAdd.getPriority());
    }

    public Note updateCommentById(long id, Note messageToUpdate) {
        boolean result = noteDAO.updateCommentById(id, messageToUpdate.getContent(), messageToUpdate.getPriority());
        if (result) {
            return noteDAO.getCommentById(id);
        } else {
            return null;
        }

    }

    public ArrayList<Note> getAllComments() {
        return noteDAO.getAllComments();
    }

    public Note getCommentById(long id) {
        return noteDAO.getCommentById(id);
    }

    public String deleteCommentById(long id) {
        boolean result = noteDAO.deleteCommentById(id);
        if (result) {
            return "Comment with ID " + id + " was deleted.";
        } else {
            return "Comment with ID " + id + " was not found or could not be deleted.";
        }

    }

    public Note updateCommentPriorityById(long id, String priority) {
        boolean result = noteDAO.updateCommentPriorityById(id, priority);
        if (result) {
            return noteDAO.getCommentById(id);
        } else {
            return null;
        }
    }
}

package com.omondi.controller;

import java.util.ArrayList;

import com.omondi.model.Note;
import com.omondi.service.NoteService;

import io.javalin.Javalin;
import io.javalin.http.Context;

public class NoteController {
    // Dependencies
    private NoteService noteService;

    public NoteController() {
        this.noteService = new NoteService();
    }

    public void setup() {
        Javalin app = Javalin.create().start(9000);
        app.get("/", ctx -> {
            System.out.println("Testing testing, anyone there?!");
            ctx.result("Hello World!");
        });
        app.post("/comments", this::addMessage);
        app.put("/comments/{id}", this::updateCommentById);
        app.get("/comments", this::getAllComments);
        app.get("/comments/{id}", this::getCommentById);
        app.delete("/comments/{id}", this::deleteCommentById);
        app.patch("/comments/{id}", this::updateCommentPriorityById);
    }

    private void updateCommentPriorityById(Context ctx) {
        long idFromPath = Long.parseLong(ctx.pathParam("id"));
        String queryParamVal = ctx.queryParam("priority");

        Note updatedPriority = noteService.updateCommentPriorityById(idFromPath, queryParamVal);

        if (updatedPriority != null) {
            ctx.json(updatedPriority).status(200);
        } else {
            ctx.result("Comment priority was not updated").status(400);
        }
    }

    private void deleteCommentById(Context ctx) {
        long id = Long.parseLong(ctx.pathParam("id"));
        String commentDeleted = noteService.deleteCommentById(id);
        if (commentDeleted != null) {
            ctx.json(commentDeleted).status(200);
        } else {
            ctx.result("Comment was not deleted").status(400);
        }
    }

    private void getCommentById(Context ctx) {
        // Information from request
        long idFromPath = Long.parseLong(ctx.pathParam("id"));
        // Call service layer method
        Note commentReceived = noteService.getCommentById(idFromPath);
        // Send response
        if (commentReceived != null) {
            ctx.json(commentReceived).status(200);
        } else {
            ctx.result("No comment associated with this id").status(400);
        }
    }

    private void getAllComments(Context ctx) {
        ArrayList<Note> commentsReturned = noteService.getAllComments();
        ctx.json(commentsReturned).status(200);
    }

    private void addMessage(Context ctx) {
        // Information from request
        Note messageFromBody = ctx.bodyAsClass(Note.class);
        // Call service layer method
        Note messageInserted = noteService.addMessage(messageFromBody);
        // Send response
        if (messageInserted != null) {
            ctx.json(messageInserted).status(200);
        } else {
            ctx.result("Message not added.").status(400);
        }
    }

    private void updateCommentById(Context ctx) {
        // Information from request
        Note messageFromBody = ctx.bodyAsClass(Note.class);
        long idFromPath = Long.parseLong(ctx.pathParam("id"));
        // Call service layer method
        Note updatedMessage = noteService.updateCommentById(idFromPath, messageFromBody);
        // Send response
        if (updatedMessage != null) {
            ctx.json(updatedMessage).status(200);
        } else {
            ctx.result("Message not updated.").status(400);
        }
    }

}

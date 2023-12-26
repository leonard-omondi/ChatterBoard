package com.omondi.model;

import java.util.Objects;

public class Note {
    private long id;
    private String comment;
    private String priority;

    public Note() {
    }

    public Note(long id, String comment, String priority) {
        this.id = id;
        this.comment = comment;
        this.priority = priority;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Note id(long id) {
        setId(id);
        return this;
    }

    public Note comment(String comment) {
        setComment(comment);
        return this;
    }

    public Note priority(String priority) {
        setPriority(priority);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Note)) {
            return false;
        }
        Note note = (Note) o;
        return id == note.id && Objects.equals(comment, note.comment) && Objects.equals(priority, note.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment, priority);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", comment='" + getComment() + "'" +
                ", priority='" + getPriority() + "'" +
                "}";
    }

}

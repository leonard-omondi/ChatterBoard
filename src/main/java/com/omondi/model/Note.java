package com.omondi.model;

import java.util.Objects;

public class Note {
    private long id;
    private String content;
    private String priority;

    public Note() {
    }

    public Note(long id, String content, String priority) {
        this.id = id;
        this.content = content;
        this.priority = priority;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Note content(String content) {
        setContent(content);
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
        return id == note.id && Objects.equals(content, note.content) && Objects.equals(priority, note.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, priority);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", content='" + getContent() + "'" +
                ", priority='" + getPriority() + "'" +
                "}";
    }

}

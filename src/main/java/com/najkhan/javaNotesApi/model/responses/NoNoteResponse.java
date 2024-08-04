package com.najkhan.javaNotesApi.model.responses;

import lombok.Data;

@Data
public class NoNoteResponse implements NotesResponse {
    private String noNote;
    public NoNoteResponse(String title) {
        this.noNote = "No Note found with title: " + title;
    }
}

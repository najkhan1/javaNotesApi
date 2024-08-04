package com.najkhan.javaNotesApi.model.responses;

import lombok.Data;

@Data
public class DeleteNoteResponse {
    private String noteDeleted;
    public DeleteNoteResponse(String title){
        this.noteDeleted = "note with title: " + title + " deleted";
    }
}

package com.najkhan.javaNotesApi.model.responses;


import lombok.Data;

@Data
public class NoteAlreadyExistsResponse implements NotesResponse {

    private final String titleAlreadyExist;

    public NoteAlreadyExistsResponse(String title) {
        this.titleAlreadyExist = "Title already exists please choose a different title or use update endpoint";
    }

}

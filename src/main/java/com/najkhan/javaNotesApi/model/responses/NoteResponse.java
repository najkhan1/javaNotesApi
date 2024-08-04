package com.najkhan.javaNotesApi.model.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteResponse implements NotesResponse {
    private String title;
    private String note;
}

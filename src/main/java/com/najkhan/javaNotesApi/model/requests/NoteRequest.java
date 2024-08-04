package com.najkhan.javaNotesApi.model.requests;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteRequest {
    private final String email;
    private final String title;
}

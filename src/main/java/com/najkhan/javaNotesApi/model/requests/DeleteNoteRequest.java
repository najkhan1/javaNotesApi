package com.najkhan.javaNotesApi.model.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
public class DeleteNoteRequest {
    @JsonProperty("title")
    private String title;

    public DeleteNoteRequest() {
    }
}

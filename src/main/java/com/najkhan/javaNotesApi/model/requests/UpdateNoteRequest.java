package com.najkhan.javaNotesApi.model.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateNoteRequest {
    private String title;
    private String note;
}

package com.najkhan.javaNotesApi.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteNoteDto {
    private String Email;
    private String title;
}

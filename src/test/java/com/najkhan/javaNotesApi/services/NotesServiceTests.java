package com.najkhan.javaNotesApi.services;

import com.najkhan.javaNotesApi.model.Notes;
import com.najkhan.javaNotesApi.model.requests.NoteRequest;
import com.najkhan.javaNotesApi.model.responses.NoteResponse;
import com.najkhan.javaNotesApi.model.responses.NotesResponse;
import com.najkhan.javaNotesApi.repository.NotesRepository;
import com.najkhan.javaNotesApi.repository.UsersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NotesServiceTests {

    private String email = "some@email.com";
    private String title = "note title";
    private String noteSting = "Some note String";
    private NoteRequest noteRequest = NoteRequest
            .builder()
            .email(email)
            .title(title)
            .build();
    private NoteResponse note = NoteResponse
            .builder()
            .title(title)
            .note(noteSting)
            .build();

    @Mock
    NotesRepository notesRepository;

    @InjectMocks
    NotesService notesService;

    @DisplayName("getNote should return correct note")
    @Test
    public void whenNoteRequest_thenGetNote_ReturnsRightOptionalOfNote_withCorrectNote(){

        when(notesRepository.getNotesByEmailAndTitle(email, title)).thenReturn(note);
        Optional<NoteResponse> expected = Optional.of(note);
        Optional<NoteResponse> result = notesService.getNote(noteRequest);

        Assertions.assertEquals(result,expected);
    }

    @DisplayName("getNote should return Option of null if note note found")
    @Test
    public void whenNoNoteFound_thenGetNote_ReturnsRightOptionalOfNote(){

        when(notesRepository.getNotesByEmailAndTitle(email, title)).thenReturn(null);
        Optional<NoteResponse> expected = Optional.empty();
        Optional<NoteResponse> result = notesService.getNote(noteRequest);

        Assertions.assertEquals(result,expected);
    }

    @DisplayName("getNotes should return list notes responses")
    @Test
    public void whenNotesFound_thenGetNote_ReturnsListOfNotes(){

        when(notesRepository.getNotesByEmail(email)).thenReturn(List.of(note));
        List<NoteResponse> expected = List.of(note);
        List<NoteResponse> result = notesService.getNotes(email);

        Assertions.assertEquals(result,expected);
        Assertions.assertEquals(result.size(),1);
    }

    @DisplayName("getNotes should return empty list when no notes found")
    @Test
    public void whenNoNotesFound_thenGetNote_ReturnsEmptyList(){

        when(notesRepository.getNotesByEmail(email)).thenReturn(List.of());
        List<NoteResponse> expected = List.of();
        List<NoteResponse> result = notesService.getNotes(email);

        Assertions.assertEquals(result,expected);
        Assertions.assertEquals(result.size(),0);
    }


}

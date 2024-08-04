package com.najkhan.javaNotesApi.Controller;

import com.najkhan.javaNotesApi.model.Notes;
import com.najkhan.javaNotesApi.model.dto.DeleteNoteDto;
import com.najkhan.javaNotesApi.model.requests.CreateNoteRequest;
import com.najkhan.javaNotesApi.model.requests.DeleteNoteRequest;
import com.najkhan.javaNotesApi.model.requests.NoteRequest;
import com.najkhan.javaNotesApi.model.requests.UpdateNoteRequest;
import com.najkhan.javaNotesApi.model.responses.*;
import com.najkhan.javaNotesApi.services.NotesService;
import com.najkhan.javaNotesApi.services.UsersService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Log4j2
@Controller
@RequestMapping("/notes")
public class NotesController {
    @Autowired
    private NotesService notesService;
    private UsersService userService;

    @GetMapping("/{title}")
    public ResponseEntity<NotesResponse> getNote(@PathVariable String title) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentUserEmail = authentication.getName();
        NoteRequest noteRequest = NoteRequest.builder()
                .email(currentUserEmail)
                .title(title)
                .build();
        Optional<NoteResponse> noteResponse = notesService.getNote(noteRequest);
        if (noteResponse.isEmpty()) {
            NoNoteResponse noNoteResponse = new NoNoteResponse(title);
            return ResponseEntity.status(404).body(noNoteResponse);
        } else {
            return ResponseEntity.ok(noteResponse.get());
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<NoteResponse>> getNotes() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentUserEmail = authentication.getName();

        return ResponseEntity.ok(notesService.getNotes(currentUserEmail));
    }

    @PostMapping("/")
    public ResponseEntity<NotesResponse> createNote(@RequestBody CreateNoteRequest createNoteRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentUserEmail = authentication.getName();

        NoteRequest noteRequest = NoteRequest.builder()
                .email(currentUserEmail)
                .title(createNoteRequest.getTitle())
                .build();
        Optional<NoteResponse> noteResponse = notesService.getNote(noteRequest);

        if (noteResponse.isEmpty()) {

            Notes createNoteDto = Notes.builder()
                    .email(currentUserEmail)
                    .title(createNoteRequest.getTitle())
                    .note(createNoteRequest.getNote())
                    .build();

            Notes note = notesService.upsertNote(createNoteDto);
            NoteResponse response = NoteResponse.builder()
                    .title(note.getTitle())
                    .note(note.getNote())
                    .build();

            return ResponseEntity.status(201).body(response);

        } else {
            return ResponseEntity
                    .status(409)
                    .body(new NoteAlreadyExistsResponse(noteRequest.getTitle()));
        }
    }

    @PutMapping("/")
    public ResponseEntity<NotesResponse> updateNote(@RequestBody UpdateNoteRequest updateNoteRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        Notes note = Notes
                .builder()
                .email(email)
                .title(updateNoteRequest.getTitle())
                .note(updateNoteRequest.getNote())
                .build();
        Notes updateNote = notesService.upsertNote(note);
        NoteResponse response = NoteResponse.builder()
                .title(updateNote.getTitle())
                .note(updateNote.getNote())
                .build();
        return ResponseEntity.status(201).body(response);
    }

    @PostMapping("/delete")
    public ResponseEntity<DeleteNoteResponse> deleteNote(@RequestBody DeleteNoteRequest deleteNoteRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        DeleteNoteDto deleteNoteDto = DeleteNoteDto
                .builder()
                .Email(email)
                .title(deleteNoteRequest.getTitle())
                .build();
        notesService.deleteNote(deleteNoteDto);
        return ResponseEntity.status(200).body(new DeleteNoteResponse(deleteNoteRequest.getTitle()));
    }


}

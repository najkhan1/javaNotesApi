package com.najkhan.javaNotesApi.services;

import com.najkhan.javaNotesApi.model.Notes;
import com.najkhan.javaNotesApi.model.dto.DeleteNoteDto;
import com.najkhan.javaNotesApi.model.requests.DeleteNoteRequest;
import com.najkhan.javaNotesApi.model.requests.NoteRequest;
import com.najkhan.javaNotesApi.model.responses.NoteResponse;
import com.najkhan.javaNotesApi.repository.NotesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotesService {

    private final NotesRepository notesRepository;

    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public Optional<NoteResponse> getNote(NoteRequest request) {
        return Optional.ofNullable(notesRepository.getNotesByEmailAndTitle(request.getEmail(), request.getTitle()));
    }

    public List<NoteResponse> getNotes(String email) {
        return notesRepository.getNotesByEmail(email);
    }

    public Notes upsertNote(Notes createNoteDto) {
        return notesRepository.save(createNoteDto);
    }

    public void deleteNote(DeleteNoteDto deleteNoteDto) {
        notesRepository.deleteNotesByEmailAndTitle(deleteNoteDto.getEmail(),deleteNoteDto.getTitle());
    }

}

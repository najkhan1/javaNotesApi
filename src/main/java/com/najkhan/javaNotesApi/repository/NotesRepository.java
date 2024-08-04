package com.najkhan.javaNotesApi.repository;

import com.najkhan.javaNotesApi.model.Notes;
import com.najkhan.javaNotesApi.model.requests.NoteRequest;
import com.najkhan.javaNotesApi.model.responses.NoteResponse;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends CassandraRepository<Notes, String> {

    public NoteResponse getNotesByEmailAndTitle(String email, String title);

    public List<NoteResponse> getNotesByEmail(String Email);

    public void deleteNotesByEmailAndTitle(String email, String title);

}

package com.example.note.server.model.repository;

import com.example.note.server.model.entity.Notes;
import com.example.note.server.model.repository.custom.NotesRepositoryCustom;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface NotesRepository extends CrudRepository<Notes, Long>, QuerydslPredicateExecutor<Notes>, NotesRepositoryCustom {
}

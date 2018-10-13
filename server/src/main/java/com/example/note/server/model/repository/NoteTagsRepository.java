package com.example.note.server.model.repository;

import com.example.note.server.model.entity.NoteTags;
import com.example.note.server.model.repository.custom.NoteTagsRepositoryCustom;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface NoteTagsRepository extends CrudRepository<NoteTags, Long>, QuerydslPredicateExecutor<NoteTags>, NoteTagsRepositoryCustom {
}

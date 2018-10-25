package com.example.note.server.model.repository.impl;

import com.example.note.server.model.repository.custom.NotesRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class NotesRepositoryImpl implements NotesRepositoryCustom {
    @Setter(onMethod = @__({@Autowired, @Qualifier("mysqlJpaQueryFactory")}))
    private JPAQueryFactory query;
}

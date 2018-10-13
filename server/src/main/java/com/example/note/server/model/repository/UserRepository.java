package com.example.note.server.model.repository;

import com.example.note.server.model.entity.User;
import com.example.note.server.model.repository.custom.UserRepositoryCustom;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>, QuerydslPredicateExecutor<User>, UserRepositoryCustom {
    User findByEmail(String email);
}

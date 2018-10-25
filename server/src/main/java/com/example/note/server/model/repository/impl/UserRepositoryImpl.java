package com.example.note.server.model.repository.impl;

import com.example.note.server.model.entity.QUser;
import com.example.note.server.model.objects.Role;
import com.example.note.server.model.repository.custom.UserRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {
    @Setter(onMethod = @__({@Autowired, @Qualifier("mysqlJpaQueryFactory")}))
    private JPAQueryFactory query;

    @Override
    public String getPasswordByEmail(String email) {
        return query
                .select(QUser.user.password)
                .from(QUser.user)
                .where(QUser.user.email.eq(email))
                .fetchOne();
    }

    @Override
    public Role getRoleByEmail(String email) {
        return query
                .select(QUser.user.role)
                .from(QUser.user)
                .where(QUser.user.email.eq(email))
                .fetchOne();
    }
}

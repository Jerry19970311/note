package com.example.note.server.model.bean;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class JpaFactoryBean {
    @PersistenceContext
    private EntityManager entityManager;
    private JPAQueryFactory jpaQueryFactory;

    public JpaFactoryBean() {
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Bean
    public JPAQueryFactory getJpaQueryFactory() {
        return this.jpaQueryFactory;
    }
}

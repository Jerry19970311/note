package com.example.note.server.model.bean;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class MySQLJpaFactoryBean {
    @Setter(onMethod = @__({@Autowired, @Qualifier("mysqlEntityManager")}))
    private EntityManager entityManager;
    private JPAQueryFactory jpaQueryFactory;

    public MySQLJpaFactoryBean() {
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Bean(name = "mysqlJpaQueryFactory")
    public JPAQueryFactory getJpaQueryFactory() {
        return this.jpaQueryFactory;
    }
}

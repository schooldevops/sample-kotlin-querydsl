package com.schooldevops.querydslsample.config

//import com.querydsl.jpa.impl.JPAQueryFactory
//import jakarta.persistence.EntityManager
//import jakarta.persistence.PersistenceContext
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
//import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Configuration
//open
class QuerydslConfiguration(
    @PersistenceContext
    private val entityManager: EntityManager
) {

    @Bean
//    open
    fun jpaQueryFactory(): JPAQueryFactory = JPAQueryFactory(entityManager)
}
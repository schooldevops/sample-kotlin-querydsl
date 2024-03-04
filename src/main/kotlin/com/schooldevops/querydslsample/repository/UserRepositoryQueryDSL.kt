package com.schooldevops.querydslsample.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.schooldevops.querydslsample.models.QUser
import com.schooldevops.querydslsample.models.User
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryQueryDSL(
    private val jpaQueryFactory: JPAQueryFactory,
) {

    fun getLists(): List<User> {
        return jpaQueryFactory.selectFrom(QUser.user).fetch();
    }

}
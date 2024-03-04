package com.schooldevops.querydslsample.repository

import com.schooldevops.querydslsample.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>{
}
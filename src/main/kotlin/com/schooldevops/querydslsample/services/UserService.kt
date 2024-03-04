package com.schooldevops.querydslsample.services

import com.schooldevops.querydslsample.models.User
import com.schooldevops.querydslsample.repository.UserRepository
import com.schooldevops.querydslsample.repository.UserRepositoryQueryDSL
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userRepositoryQueryDSL: UserRepositoryQueryDSL
) {

    fun createUser(name: String, email: String): User {
        val newUser = User(name = name, email = email)
        return userRepository.save(newUser)
    }

    fun getUsers(): List<User> {
        return userRepository.findAll()
    }

    fun getUserByQueryDSL(): List<User> {
        return userRepositoryQueryDSL.getLists()
    }

    fun updateUser(id: Long, name: String, email: String): User {
        val existingUser = userRepository.findById(id)
            .orElseThrow { throw RuntimeException("User not found with id: $id") }
        existingUser.name = name
        existingUser.email = email
        return userRepository.save(existingUser)
    }

    fun deleteUser(id: Long) {
        userRepository.deleteById(id)
    }


}
package com.schooldevops.querydslsample

import com.schooldevops.querydslsample.models.User
import com.schooldevops.querydslsample.services.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class UserController(
    private val userService: UserService
) {

    @GetMapping("/users")
    fun getUsers() : List<User> {
        val userByQueryDSL = userService.getUserByQueryDSL()

        return userByQueryDSL
    }

    @PostMapping("/users")
    fun insertUser(@RequestBody user: User): User {
        val createUser = userService.createUser(user.name, user.email)
        return createUser
    }
}
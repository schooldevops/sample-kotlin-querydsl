package com.schooldevops.querydslsample.models

import javax.persistence.*

//import jakarta.persistence.*

@Entity
@Table(name = "user")
class User (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var userId: Long? = null,
    var name: String,
    var email: String
)

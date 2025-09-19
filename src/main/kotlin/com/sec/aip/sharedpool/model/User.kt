package com.sec.aip.sharedpool.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("users")
data class User(
    @Id
    val userId: String,
    val userName: String,
    val gender: String,
    val email: String,
    val phoneNumber: String
)

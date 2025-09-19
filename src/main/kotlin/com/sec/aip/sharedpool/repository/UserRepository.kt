package com.sec.aip.sharedpool.repository

import com.sec.aip.sharedpool.model.User
import org.springframework.data.r2dbc.repository.R2dbcRepository

interface UserRepository : R2dbcRepository<User, String>

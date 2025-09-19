package com.sec.aip.sharedpool.controller

import com.sec.aip.sharedpool.model.User
import com.sec.aip.sharedpool.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/users")
class UserController(private val userRepository: UserRepository) {

    @GetMapping
    fun getUsers(): Flux<User> {
        return userRepository.findAll()
    }

    @GetMapping("/{userId}")
    fun getUserById(@PathVariable userId: String): Mono<User> {
        return userRepository.findById(userId)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody user: User): Mono<User> {
        return userRepository.save(user)
    }

    @PutMapping("/{userId}")
    fun updateUser(@PathVariable userId: String, @RequestBody user: User): Mono<User> {
        return userRepository.findById(userId)
            .flatMap { existingUser ->
                val updatedUser = existingUser.copy(
                    userName = user.userName,
                    gender = user.gender,
                    email = user.email,
                    phoneNumber = user.phoneNumber
                )
                userRepository.save(updatedUser)
            }
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable userId: String): Mono<Void> {
        return userRepository.deleteById(userId)
    }
}

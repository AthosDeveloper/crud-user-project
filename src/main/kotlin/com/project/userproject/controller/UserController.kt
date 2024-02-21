package com.project.userproject.controller

import com.project.userproject.domain.model.User
import com.project.userproject.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController (private  val userService: UserService) {
@GetMapping
fun listUsers(): ResponseEntity<List<User>> = ResponseEntity.ok(userService.findAll())
@GetMapping("/{id}")
fun getUserById(@PathVariable id: Long): ResponseEntity<User> =
        userService.findById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
@PostMapping
fun createUser(@RequestBody user: User): ResponseEntity<User> = ResponseEntity.ok(userService.save(user))
@PutMapping("@{id}")
fun updateUser(@PathVariable id: Long, @RequestBody user: User): ResponseEntity<User> =
        userService.findById(id)?.let {
            val updatedUser = it.copy(name = user.name, email = user.email)
            ResponseEntity.ok(userService.save(updatedUser))
        } ?:ResponseEntity.notFound().build()

}
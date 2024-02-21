package com.project.userproject.controller

import com.project.userproject.domain.model.User
import com.project.userproject.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController (private  val userService: UserService) {
@GetMapping
fun listUsers(): ResponseEntity<List<User>> = ResponseEntity.ok(userService.findAll())

}
package com.project.userproject.controller

import com.project.userproject.domain.DTO.UserDTO
import com.project.userproject.domain.model.User
import com.project.userproject.exception.ResourceNotFoundException
import com.project.userproject.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
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
fun listUsers(): ResponseEntity<List<UserDTO>> = ResponseEntity.ok(userService.findAll())
@GetMapping("/{id}")
fun getUserById(@PathVariable id: Long): ResponseEntity<UserDTO> =
        userService.findById(id)?.let { ResponseEntity.ok(it) } ?: throw ResourceNotFoundException("user not found")
@PostMapping
fun createUser(@RequestBody userDTO: UserDTO): ResponseEntity<UserDTO> = ResponseEntity.ok(userService.save(userDTO))
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> =
            userService.findById(id)?.let {
                userService.deleteById(id)
                ResponseEntity<Void>(HttpStatus.OK)
            } ?: throw ResourceNotFoundException("user not found with id $id")
    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody userDTO: UserDTO): ResponseEntity<UserDTO> =
            userService.findById(id)?.let {
                val updatedUserDTO = it.copy(name = userDTO.name, email = userDTO.email)
                ResponseEntity.ok(userService.save(updatedUserDTO))
            } ?: throw ResourceNotFoundException("user not found with id $id")

}
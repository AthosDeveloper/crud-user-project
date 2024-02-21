package com.project.userproject.service

import com.project.userproject.domain.model.User
import com.project.userproject.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
  fun findAll():List<User> = userRepository.findAll()
    fun findById (id: Long): User? = userRepository.findById(id).orElse(null)
    fun save(user: User): User = userRepository.save(user)
fun deleteById (id: Long)= userRepository.deleteById(id)
}
package com.project.userproject.service

import com.project.userproject.domain.DTO.UserDTO
import com.project.userproject.domain.model.User
import com.project.userproject.repository.UserRepository
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository,
        private val modelMapper: ModelMapper) {
  fun findAll():List<UserDTO> = userRepository.findAll()
          .map { user -> modelMapper.map(user, UserDTO::class.java) }
    fun findById (id: Long): UserDTO? = userRepository.findById(id)
            .map { user -> modelMapper.map(user, UserDTO::class.java) }.orElse(null)
    fun save(userDTO: UserDTO): UserDTO {
      val user = modelMapper.map(userDTO, User::class.java)
      val savedUser = userRepository.save(user)
      return modelMapper.map(savedUser, UserDTO::class.java)
    }
fun deleteById (id: Long)= userRepository.deleteById(id)

}
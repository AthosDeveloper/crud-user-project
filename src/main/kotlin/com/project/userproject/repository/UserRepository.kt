package com.project.userproject.repository

import com.project.userproject.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository:JpaRepository<User, Long> {
}
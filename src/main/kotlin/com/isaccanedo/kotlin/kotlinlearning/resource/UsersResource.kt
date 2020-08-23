package com.techprimers.kotlin.kotlinlearning.resource

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@RestController
@RequestMapping("/rest/users")
class UsersResource(val usersRepository: UsersRepository) {

    @GetMapping(value = "/all")
    fun getUsers() = usersRepository.findAll()

    @GetMapping(value = "/insert/{name}")
    fun insertUsers(@PathVariable name: String): List<Users> {
        val users = Users(name)
        usersRepository.save(users)
        return usersRepository.findAll()
    }
}

@Entity
class Users(val name: String = "",
            val salary: Int = 2000,
            @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
            val id: Long = 0)

interface UsersRepository : JpaRepository<Users, Long>
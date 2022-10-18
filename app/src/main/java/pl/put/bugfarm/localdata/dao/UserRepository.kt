package pl.put.bugfarm.localdata.dao

import kotlinx.coroutines.flow.Flow
import pl.put.bugfarm.domain.User

interface UserRepository{
    fun validateUser(name: String, password: String): String
    fun addUser(name: String,password: String)
}
package pl.put.bugfarm.localdata.dao

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import pl.put.bugfarm.domain.User

class UserRepositoryImpl(private val dao: UserDao):UserRepository {
    override fun validateUser(name: String, password: String): String{
        Log.d("repo","repo")
        return dao.checkUser(name,password)
    }

    override fun addUser(name: String,password: String){
        dao.addUser(User(name,password))
    }
}
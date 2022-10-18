package pl.put.bugfarm.localdata.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.ABORT
import androidx.room.Query
import pl.put.bugfarm.domain.User

@Dao
interface UserDao {
    @Query("Select name FROM USER WHERE (name = :name) and (password =:password)")
    fun checkUser(name: String, password: String): String

    @Insert(onConflict = ABORT)
    fun addUser(user: User)
    }


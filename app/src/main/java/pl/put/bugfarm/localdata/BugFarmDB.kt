package pl.put.bugfarm.localdata

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.put.bugfarm.domain.User
import pl.put.bugfarm.localdata.dao.UserDao

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class BugFarmDB: RoomDatabase() {
    abstract fun userDao():UserDao
}
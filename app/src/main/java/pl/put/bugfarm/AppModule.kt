package pl.put.bugfarm

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pl.put.bugfarm.localdata.BugFarmDB
import pl.put.bugfarm.localdata.dao.UserDao
import pl.put.bugfarm.localdata.dao.UserRepository
import pl.put.bugfarm.localdata.dao.UserRepositoryImpl


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideBugFarmDB(
        @ApplicationContext
        context : Context
    ) = Room.databaseBuilder(
        context,
        BugFarmDB::class.java,
        "bug_farm.db"
    ).build()

    @Provides
    fun provideUserDao(
        bugFarmDB: BugFarmDB
    ) = bugFarmDB.userDao()

    @Provides
    fun provideUserRepository(
        userDao: UserDao
    )= UserRepositoryImpl(userDao)
}
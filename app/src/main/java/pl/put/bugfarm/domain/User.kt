package pl.put.bugfarm.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "USER")
data class User(
    @PrimaryKey
    @ColumnInfo(name = "NAME")
    val name: String,
    @ColumnInfo(name = "PASSWORD")
    val password: String
)
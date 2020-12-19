package net.android.connectivechurch.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import net.android.connectivechurch.model.*

@Dao
interface PostDao {

    @Query("SELECT * FROM jsondata")
    fun findAllJson(): JsonData

    @Query("SELECT * FROM comment")
    fun findAllComment(): Comment

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addJson(users: JsonData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addComment(comment: Comment)

}
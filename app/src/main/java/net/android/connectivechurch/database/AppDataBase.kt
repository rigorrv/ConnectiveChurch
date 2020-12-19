package net.android.connectivechurch.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import net.android.connectivechurch.model.*
import net.android.connectivechurch.model.converters.*

@Database(
    entities = [JsonData::class, Comment::class
    ], version = 1
)
@TypeConverters(
    //CommentConverter::class,
    VideoItemConverter::class,
    Converters::class,
    AboutConverter::class,
    BelongConverter::class,
    CommentItemConverter::class,
    CommentsConverter::class,
    ContactConverter::class,
    GivingConverter::class,
    GroupsConverter::class,
    MessagesConverter::class,
    MoreAboutItemConverter::class,
    VideoConverter::class,
    VisitConverter::class

)
abstract class AppDataBase : RoomDatabase() {
    abstract fun postDao(): PostDao
}
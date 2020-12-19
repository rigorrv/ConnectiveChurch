package net.android.connectivechurch.model.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import net.android.connectivechurch.model.Comment

class CommentConverter {

    @TypeConverter
    fun stringToComment(json: String): Comment? {
        val gson = Gson()
        val type = object : TypeToken<Comment>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun CommentToString(Comment: Comment): String {
        val gson = Gson()
        val type = object : TypeToken<Comment>() {}.type
        return gson.toJson(Comment, type)
    }



}
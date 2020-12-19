package net.android.connectivechurch.model.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import net.android.connectivechurch.model.Messages

class MessagesConverter {

    @TypeConverter
    fun stringToMessages(json: String): Messages? {
        val gson = Gson()
        val type = object : TypeToken<Messages>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun MessagesToString(Messages: Messages): String {
        val gson = Gson()
        val type = object : TypeToken<Messages>() {}.type
        return gson.toJson(Messages, type)
    }
}
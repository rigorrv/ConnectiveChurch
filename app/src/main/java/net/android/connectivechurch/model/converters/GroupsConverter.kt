package net.android.connectivechurch.model.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import net.android.connectivechurch.model.Groups

class GroupsConverter {

    @TypeConverter
    fun stringToGroups(json: String): Groups? {
        val gson = Gson()
        val type = object : TypeToken<Groups>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun GroupsToString(Groups: Groups): String {
        val gson = Gson()
        val type = object : TypeToken<Groups>() {}.type
        return gson.toJson(Groups, type)
    }
}
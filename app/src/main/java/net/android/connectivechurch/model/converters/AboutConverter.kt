package net.android.connectivechurch.model.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import net.android.connectivechurch.model.About

class AboutConverter {

    @TypeConverter
    fun stringToAbout(json: String): About? {
        val gson = Gson()
        val type = object : TypeToken<About>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun AboutToString(About: About): String {
        val gson = Gson()
        val type = object : TypeToken<About>() {}.type
        return gson.toJson(About, type)
    }


}
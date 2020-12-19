package net.android.connectivechurch.model.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import net.android.connectivechurch.model.Giving

class GivingConverter {

    @TypeConverter
    fun stringToGiving(json: String): Giving? {
        val gson = Gson()
        val type = object : TypeToken<Giving>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun GivingToString(Giving: Giving): String {
        val gson = Gson()
        val type = object : TypeToken<Giving>() {}.type
        return gson.toJson(Giving, type)
    }
}
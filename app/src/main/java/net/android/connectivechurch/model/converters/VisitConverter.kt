package net.android.connectivechurch.model.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import net.android.connectivechurch.model.Visit

class VisitConverter {

    @TypeConverter
    fun stringToVisit(json: String): Visit? {
        val gson = Gson()
        val type = object : TypeToken<Visit>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun VisitToString(Visit: Visit): String {
        val gson = Gson()
        val type = object : TypeToken<Visit>() {}.type
        return gson.toJson(Visit, type)
    }
}
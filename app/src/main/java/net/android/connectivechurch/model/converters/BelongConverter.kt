package net.android.connectivechurch.model.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import net.android.connectivechurch.model.Belong

class BelongConverter {

    @TypeConverter
    fun stringToBelong(json: String): Belong? {
        val gson = Gson()
        val type = object : TypeToken<Belong>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun BelongToString(Belong: Belong): String {
        val gson = Gson()
        val type = object : TypeToken<Belong>() {}.type
        return gson.toJson(Belong, type)
    }
}
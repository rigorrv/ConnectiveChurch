package net.android.connectivechurch.model.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import net.android.connectivechurch.model.Contact

class ContactConverter {

    @TypeConverter
    fun stringToContact(json: String): Contact? {
        val gson = Gson()
        val type = object : TypeToken<Contact>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun ContactToString(Contact: Contact): String {
        val gson = Gson()
        val type = object : TypeToken<Contact>() {}.type
        return gson.toJson(Contact, type)
    }
}
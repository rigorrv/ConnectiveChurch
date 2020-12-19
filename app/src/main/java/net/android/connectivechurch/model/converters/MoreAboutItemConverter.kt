package net.android.connectivechurch.model.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import net.android.connectivechurch.model.MoreAboutItem

class MoreAboutItemConverter {

    @TypeConverter
    fun fromAddressList(moreAbout : List<MoreAboutItem?>?): String?{
        val type = object : TypeToken<List<MoreAboutItem?>?>(){}.type
        return Gson().toJson(moreAbout,type)
    }
    @TypeConverter
    fun toAddresList(moreAbout : String?): List<MoreAboutItem>?{
        val type = object : TypeToken<List<MoreAboutItem?>?>(){}.type
        return Gson().fromJson<List<MoreAboutItem>>(moreAbout,type)
    }



}
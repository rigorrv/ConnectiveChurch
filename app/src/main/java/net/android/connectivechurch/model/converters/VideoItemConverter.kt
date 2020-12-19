package net.android.connectivechurch.model.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import net.android.connectivechurch.model.VideoItem

class VideoItemConverter {

    @TypeConverter
    fun fromAddressList(moreAbout : List<VideoItem?>?): String?{
        val type = object : TypeToken<List<VideoItem?>?>(){}.type
        return Gson().toJson(moreAbout,type)
    }
    @TypeConverter
    fun toAddresList(moreAbout : String?): List<VideoItem>?{
        val type = object : TypeToken<List<VideoItem?>?>(){}.type
        return Gson().fromJson<List<VideoItem>>(moreAbout,type)
    }



}
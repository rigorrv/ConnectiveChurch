package net.android.connectivechurch.model.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import net.android.connectivechurch.model.VideoItem
import net.android.connectivechurch.model.Video

class VideoConverter {

    @TypeConverter
    fun stringToVideo(json: String): Video? {
        val gson = Gson()
        val type = object : TypeToken<Video>() {}.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun VideoToString(Video: Video): String {
        val gson = Gson()
        val type = object : TypeToken<Video>() {}.type
        return gson.toJson(Video, type)
    }
}
package net.android.connectivechurch.model.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import net.android.connectivechurch.model.CommentItem

class CommentItemConverter {


    @TypeConverter
    fun fromAddressList(moreAbout : List<CommentItem?>?): String?{
        val type = object : TypeToken<List<CommentItem?>?>(){}.type
        return Gson().toJson(moreAbout,type)
    }
    @TypeConverter
    fun toAddresList(moreAbout : String?): List<CommentItem>?{
        val type = object : TypeToken<List<CommentItem?>?>(){}.type
        return Gson().fromJson<List<CommentItem>>(moreAbout,type)
    }



}
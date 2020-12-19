package net.android.connectivechurch.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.parcel.Parcelize
import java.lang.reflect.Type

@Entity
@Parcelize
class JsonData(
    @PrimaryKey
    var about: About,
    val visit: Visit?,
    val message: Messages?,
    val giving: Giving?,
    val groups: Groups?,
    val comments: Comments?,
    val contact: Contact?,
    var moreabout: List<MoreAboutItem>,
    var belong: Belong?,
    var video: List<VideoItem>

) : Parcelable


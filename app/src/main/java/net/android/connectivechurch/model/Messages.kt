package net.android.connectivechurch.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
class Messages(
    val background : String,
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val subtitle1: String,
    val subtitle2: String,
    val btn1: String,
    val btn2: String,
    val btn3: String,
    val link1: String,
    val link2: String,
    val link3: String,
):Parcelable
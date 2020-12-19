package net.android.connectivechurch.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class MoreAboutItem(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val info: String
) : Parcelable
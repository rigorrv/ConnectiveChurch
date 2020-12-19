package net.android.connectivechurch.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
class Giving(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val info1: String,
    val button1: String,
    val subtitle1: String,
    val info2: String,
    val background: String
) : Parcelable
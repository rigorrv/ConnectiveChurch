package net.android.connectivechurch.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Belong(
    val linkaddress: String,
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val subtitle1: String,
    val info1: String,
    val info2: String,
    val info3: String,
    val subtitle2: String,
    val info4: String,
    val btn1: String,
    val btn2: String,
    val link1: String,
    val link2: String,
    val background: String,
    val backgroundbox: String
) : Parcelable
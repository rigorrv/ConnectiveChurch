package net.android.connectivechurch.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Contact(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val background: String,
    val info1: String,
    val phone: String,
    val email: String,
    val info2: String,
    val info3: String,
    val btn1: String,
    val btn2: String,
    val btn3: String,
    val link1: String,
    val link2: String,
    val link3: String,
    val phoneicon: String,
    val emailicon: String
) : Parcelable
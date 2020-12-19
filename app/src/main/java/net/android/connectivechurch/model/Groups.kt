package net.android.connectivechurch.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Groups(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val background: String,
    val info1: String,
    val button1: String
) : Parcelable
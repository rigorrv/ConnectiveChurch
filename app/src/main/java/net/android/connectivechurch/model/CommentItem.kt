package net.android.connectivechurch.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize



@Entity
@Parcelize
data class CommentItem(
    @PrimaryKey
    val id: Int,
    val comments: String,
    val dates: String,
    val image: String,
    val user: String
):Parcelable
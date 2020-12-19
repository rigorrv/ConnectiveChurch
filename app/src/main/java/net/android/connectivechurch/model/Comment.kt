package net.android.connectivechurch.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
class Comment(
    @PrimaryKey
    val comment: List<CommentItem>
) : Parcelable
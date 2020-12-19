package net.android.connectivechurch.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class About(
    val linkaddress : String,
    val azmap: String,
    val background: String,
    val button1: String,
    val button2: String,
    val color: String,
    val color1: String,
    val info1: String,
    val info2: String,
    val info3: String,
    val legal: String,
    val logo: String,
    val sentence1: String,
    val sentence10: String,
    val sentence11: String,
    val sentence12: String,
    val sentence2: String,
    val sentence3: String,
    val sentence4: String,
    val sentence5: String,
    val sentence6: String,
    val sentence7: String,
    val sentence8: String,
    val sentence9: String,
    val sentenceTitle1: String,
    val sentenceTitle10: String,
    val sentenceTitle11: String,
    val sentenceTitle12: String,
    val sentenceTitle2: String,
    val sentenceTitle3: String,
    val sentenceTitle4: String,
    val sentenceTitle5: String,
    val sentenceTitle6: String,
    val sentenceTitle7: String,
    val sentenceTitle8: String,
    val sentenceTitle9: String,
    val subtitle1: String,
    val subtitle2: String,
    val subtitle3: String,
    val subtitle4: String,
    val title: String
)
    : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
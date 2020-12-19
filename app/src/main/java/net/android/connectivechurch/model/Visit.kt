package net.android.connectivechurch.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
class Visit(
    val background : String,
    val linkaddress : String,
    val address: String,
    val answer1: String,
    val answer2: String,
    val answer3: String,
    val answer4: String,
    val answer5: String,
    val answer6: String,
    val answer7: String,
    val aswer2: String,
    val btn1: String,
    val btn2: String,
    val btn3: String,
    val buton1: String,
    val connect1: String,
    val connect2: String,
    val image: String,
    val info1: String,
    val info2: String,
    val info3: String,
    val info4: String,
    val info5: String,
    val link1: String,
    val link2: String,
    val link3: String,
    val link4: String,
    val link5: String,
    val name: String,
    val question1: String,
    val question2: String,
    val question3: String,
    val question4: String,
    val question5: String,
    val question6: String,
    val question7: String,
    val subtitle1: String,
    val subtitle2: String,
    val subtitle3: String,
    val subtitle4: String,
    val subtitle5: String,
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String
):Parcelable
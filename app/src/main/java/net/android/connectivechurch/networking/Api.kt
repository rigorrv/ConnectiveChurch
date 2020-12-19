package net.android.connectivechurch.networking

import net.android.connectivechurch.model.Comment
import net.android.connectivechurch.model.JsonData
import net.android.connectivechurch.model.Video
import retrofit2.Call
import retrofit2.http.*

interface Api {

    @GET("data.json")
    fun getJson(): Call<JsonData>

    @GET
    fun getComments(@Url url: String): Call<Comment>

    @GET
    fun getVideos(@Url url: String): Call<Video>

    /*
    @GET
    fun getMOreABout(@Url url: String): Call<MoreAbout>

     */

    @FormUrlEncoded
    @POST
    fun putComment(
        @Url url: String,
        @Field("comments") comment: String
    ): Call<Comment>


}
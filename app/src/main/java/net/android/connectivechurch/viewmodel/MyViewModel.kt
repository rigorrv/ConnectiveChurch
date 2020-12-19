package net.android.connectivechurch.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.async
import net.android.connectivechurch.database.PostDao
import net.android.connectivechurch.model.*
import net.android.connectivechurch.networking.Api
import net.android.connectivechurch.utility.Connection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class MyViewModel(private val api: Api, private val postDao: PostDao) : ViewModel() {

    var jsonLiveData = MutableLiveData<JsonData>()
    var commentLiveData = MutableLiveData<Comment>()


    init {
        if (Connection.isConnected()) {
            getJson()
            getComments()
        } else {
            loadSql()
        }
    }


    private fun getJson() {

        api.getJson().enqueue(object : Callback<JsonData> {
            override fun onResponse(call: Call<JsonData>, response: Response<JsonData>) {
                jsonLiveData.value = response.body()
                Log.d("TAG", "onResponse: ${response.body()}")
                insertSql(response.body()!!)
            }

            override fun onFailure(call: Call<JsonData>, t: Throwable) {
                Log.d("TAG", "onFailure: ${t}")
            }
        })
    }

    fun getComments() {
        api.getComments("https://nonstopcode.com/rigo/connectivechurch/comment.php")
            .enqueue(object : Callback<Comment> {
                override fun onResponse(call: Call<Comment>, response: Response<Comment>) {
                    commentLiveData.value = response.body()
                    insertComment(response.body()!!)
                }

                override fun onFailure(call: Call<Comment>, t: Throwable) {
                }
            })
    }


    fun putComment(comment: String) {
        api.putComment("https://nonstopcode.com/rigo/connectivechurch/registerApp.php", comment)
            .enqueue(object : Callback<Comment> {
                override fun onResponse(call: Call<Comment>, response: Response<Comment>) {
                    commentLiveData.value = response.body()
                    Log.d("TAG", "respuestaComment: ${response.body()}")
                    insertComment(response.body()!!)
                }

                override fun onFailure(call: Call<Comment>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t}")
                }
            })
    }

    fun insertSql(jsonData: JsonData) {
        viewModelScope.async(Dispatchers.IO + NonCancellable) {
            postDao.addJson(jsonData)
        }
    }

    fun insertComment(comment: Comment) {
        viewModelScope.async(Dispatchers.IO + NonCancellable) {
            postDao.addComment(comment)
        }
    }


    fun loadSql() {
        Log.d("TAG", "loadSql: No Connection")
        viewModelScope.async(Dispatchers.IO + NonCancellable) {
            jsonLiveData.postValue(postDao.findAllJson())
            commentLiveData.postValue(postDao.findAllComment())
        }
    }

}
package net.android.connectivechurch.injection

import android.app.Application
import androidx.room.Room
import com.google.gson.GsonBuilder
import net.android.connectivechurch.database.AppDataBase
import net.android.connectivechurch.database.PostDao
import net.android.connectivechurch.networking.Api
import net.android.connectivechurch.viewmodel.MyViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val apiModule = module {

    fun provideCountriesApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
    single { provideCountriesApi(get()) }

}

val networkModule = module {

    val gson = GsonBuilder()
        .setLenient()
        .create()

    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://notificationapp-20f51.firebaseio.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
    single { provideRetrofit() }
}


val databaseModule = module {

    fun provideDatabase(application: Application): AppDataBase {
        return Room.databaseBuilder(application, AppDataBase::class.java, "post")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun providePostDao(database: AppDataBase): PostDao {
        return database.postDao()
    }

    single { provideDatabase(androidApplication()) }
    single { providePostDao(get()) }


}


val viewModelModule = module {

    viewModel {
        MyViewModel(get(), get())
    }
}
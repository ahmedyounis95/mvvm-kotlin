package com.ahmed.mvvmkotlin.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.ahmed.mvvmkotlin.data.AppDataManager
import com.ahmed.mvvmkotlin.data.DataManager
import com.ahmed.mvvmkotlin.data.local.db.dao.ArticleListDao
import com.ahmed.mvvmkotlin.data.remote.ApiHelper
import com.ahmed.mvvmkotlin.data.remote.AppApiHelper
import com.ahmed.mvvmkotlin.utils.rx.AppSchedulerProvider
import com.ahmed.mvvmkotlin.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import hcww.mvvm.ayounis.com.mvvmproject.utils.AppConstants
import io.reactivex.disposables.CompositeDisposable
import com.ahmed.mvvmkotlin.data.local.db.AppDataBase
import javax.inject.Singleton

/**
 * Created by Ahmed Younis on 7/27/2019.
 */
@Module
class AppModule() {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    internal fun provideAppDbHelper( context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, AppConstants.DB_NAME)
            .allowMainThreadQueries().build()
    }
    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

    @Provides
    @Singleton
    internal fun provideDbHelper(appDataBase: AppDataBase): ArticleListDao {
        return appDataBase.dbHelper()
    }


    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }


}
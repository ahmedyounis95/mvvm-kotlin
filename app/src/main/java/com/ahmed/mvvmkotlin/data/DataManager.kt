package com.ahmed.mvvmkotlin.data

import com.ahmed.mvvmkotlin.data.local.db.DbHelper
import com.ahmed.mvvmkotlin.data.remote.ApiHelper

/**
 * Created by Ahmed Younis on 7/29/2019.
 */
interface DataManager : ApiHelper,DbHelper
package studio.eyesthetics.eyestheticweather

import android.app.Application
import android.content.Context

/**
 * Created by BashkatovSM on 23.07.2019
 */
class App : Application() {
    companion object{
        private var instance:App? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()

    }
}
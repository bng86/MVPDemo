package keith.kotlinmvpdemo.config.Model.repository

import android.content.Context
import keith.kotlinmvpdemo.config.ConfigValue
import keith.kotlinmvpdemo.config.Model.Cache.PreferenceFactory

class CacheRepository(context: Context) {
    private val m_ADD_LAST_RESULT_KEY = "ADD_RESULT"

    private var mContext: Context = context
    private var mAddResult by PreferenceFactory(m_ADD_LAST_RESULT_KEY, ConfigValue.ADD_NUMBER_RESULT_DEFAULT, mContext)

    fun setAddResult(x: Long) {
        mAddResult = x
    }

    fun getAddLastResult(): Long {
        return mAddResult
    }

    fun getAddLastResultKeyStr(): String {
        return m_ADD_LAST_RESULT_KEY
    }
}
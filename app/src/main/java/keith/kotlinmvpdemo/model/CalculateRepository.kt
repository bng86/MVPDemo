package keith.kotlinmvpdemo.model

import android.content.Context
import keith.kotlinmvpdemo.config.ConfigValue
import keith.kotlinmvpdemo.model.cache.PreferenceFactory
import keith.kotlinmvpdemo.presenter.calc.CalculateBridge

class CalculateRepository(context: Context) {

    private val m_ADD_LAST_RESULT_KEY = "ADD_RESULT"

    private var mContext: Context = context
    private var mAddResult by PreferenceFactory(m_ADD_LAST_RESULT_KEY, ConfigValue.ADD_NUMBER_RESULT_DEFAULT, mContext)

    fun setLastData(data: Long) {
        mAddResult = data
    }

    fun getLastData(): Long {
        return mAddResult
    }
}
package keith.kotlinmvpdemo.model.cache

import android.content.Context
import keith.kotlinmvpdemo.config.ConfigValue

class LocalStorage(context: Context) {

    companion object {
        private const val KEY_ADD_LAST_RESULT = "ADD_RESULT"
    }

    var addResult by PreferenceFactory(KEY_ADD_LAST_RESULT, ConfigValue.ADD_NUMBER_RESULT_DEFAULT, context)
}
package keith.kotlinmvpdemo.model

import android.content.Context
import keith.kotlinmvpdemo.config.ConfigValue
import keith.kotlinmvpdemo.model.cache.PreferenceFactory
import keith.kotlinmvpdemo.presenter.calc.CalculateBridge

class CalculateModel(repo: CalculateRepository) : CalculateBridge.Model {
    private val mRepo = repo

    override fun setLastData(data: Long) {
        mRepo.setLastData(data)
    }

    override fun getLastData(): Long {
        return mRepo.getLastData()
    }
}
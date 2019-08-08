package keith.kotlinmvpdemo.model

import keith.kotlinmvpdemo.model.cache.LocalStorage

class CalculateRepository(private val localStorage: LocalStorage) {

    fun setLastData(data: Long) {
        localStorage.addResult = data
    }

    fun getLastData(): Long {
        return localStorage.addResult
    }
}
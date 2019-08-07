package keith.kotlinmvpdemo.presenter.calc

import keith.kotlinmvpdemo.config.Model.repository.CacheRepository

class CalculatePresenter(cache: CacheRepository, view: CalculateBridge.View) : CalculateBridge.Presenter {
    private val mView = view

    private var mCacheTools = cache

    override fun calc(x: String, y: String) {
        if (x == "" || y == "") {
            mView.addError()
        } else {
            val result = x.toLong() + y.toLong()

            mView.addSuccess(result.toString())

            mCacheTools.setAddResult(result)
        }
    }

    override fun initData() {
        val lastResult = mCacheTools.getAddLastResult()
        mView.showLastResult(lastResult.toString())
    }

}
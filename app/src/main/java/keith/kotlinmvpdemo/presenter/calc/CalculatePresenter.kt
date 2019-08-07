package keith.kotlinmvpdemo.presenter.calc

import keith.kotlinmvpdemo.model.CalculateModel

class CalculatePresenter(model: CalculateModel, view: CalculateBridge.View) : CalculateBridge.Presenter {
    private val mView = view
    private val mModel = model

    override fun calc(x: String, y: String) {
        if (x == "" || y == "") {
            mView.addError()
        } else {
            val result = x.toLong() + y.toLong()

            mView.addSuccess(result.toString())

            mModel.setLastData(result)
        }
    }

    override fun initData() {
        val lastResult = mModel.getLastData()
        mView.showLastResult(lastResult.toString())
    }

}
package keith.kotlinmvpdemo.presenter.calc

import keith.kotlinmvpdemo.presenter.base.BaseModel
import keith.kotlinmvpdemo.presenter.base.BasePresenter
import keith.kotlinmvpdemo.presenter.base.BaseView

interface CalculateBridge {
    interface View : BaseView<Presenter> {
        fun addSuccess(result: String)

        fun addError()

        fun showLastResult(result: String)
    }

    interface Presenter : BasePresenter<Model> {
        fun calc(x: String, y: String)

        fun initData()
    }

    interface Model : BaseModel {
        fun setLastData(data: Long)

        fun getLastData(): Long
    }
}
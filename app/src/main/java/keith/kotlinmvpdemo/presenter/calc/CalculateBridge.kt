package keith.kotlinmvpdemo.presenter.calc

import keith.kotlinmvpdemo.presenter.base.BasePresenter
import keith.kotlinmvpdemo.presenter.base.BaseView

interface CalculateBridge {
    interface View : BaseView<Presenter> {
        fun addSuccess(result: String)

        fun addError()

        fun showLastResult(result: String)
    }

    interface Presenter : BasePresenter {
        fun calc(x: String, y: String)

        fun initData()
    }
}
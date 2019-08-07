package keith.kotlinmvpdemo

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import keith.kotlinmvpdemo.model.CalculateModel
import keith.kotlinmvpdemo.model.CalculateRepository
import keith.kotlinmvpdemo.presenter.calc.CalculateBridge
import keith.kotlinmvpdemo.presenter.calc.CalculatePresenter

class MainActivity : BasicActivity(), CalculateBridge.View {
    private lateinit var wTxtShow: TextView

    private lateinit var wBtnClick: Button

    private lateinit var wEditOne: EditText
    private lateinit var wEditTwo: EditText


    private lateinit var mCalcPresenter: CalculatePresenter

    override fun setViewContent() {
        setContentView(R.layout.activity_main)
    }

    override fun viewInit() {

        wTxtShow = findViewById(R.id.main_txt_show)

        wBtnClick = findViewById(R.id.main_btn)

        wEditOne = findViewById(R.id.main_edit_one)

        wEditTwo = findViewById(R.id.main_edit_two)

        //You Can Load DI Library
        mCalcPresenter = CalculatePresenter(CalculateModel(CalculateRepository(mContext)), this)
    }

    override fun setViewValue() {
        mCalcPresenter.initData()

        wBtnClick.text = "Add Number"
    }


    override fun setViewListener() {
        wBtnClick.setOnClickListener(mClickListener)
    }

    private val mClickListener = View.OnClickListener { view ->
        when (view?.id) {
            wBtnClick.id -> {
                mCalcPresenter.calc(wEditOne.text.toString(), wEditTwo.text.toString())
            }
        }
    }

    override fun addSuccess(result: String) {
        wTxtShow.text = result
    }

    override fun addError() {
        showToast(getString(R.string.add_error), true)
    }

    override fun showLastResult(result: String) {
        wTxtShow.text = result
    }
}

package keith.kotlinmvpdemo.presenter.calc

import android.content.Context
import keith.kotlinmvpdemo.model.CalculateModel
import keith.kotlinmvpdemo.model.CalculateRepository
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito


//@RunWith(PowerMockRunner::class)

class CalculatePresenterTest {

    private lateinit var mView: CalculateBridge.View
    private lateinit var mContext: Context

    @Before
    fun setup() {
        mView = Mockito.mock<CalculateBridge.View>(CalculateBridge.View::class.java)
        mContext = Mockito.mock(Context::class.java)
    }

    @Test
    fun `two number input null`() {
        //init
        val mCalcPresenter = CalculatePresenter(CalculateModel(CalculateRepository(mContext)), mView)

        mCalcPresenter.calc("", "")
        Mockito.verify<CalculateBridge.View>(mView).addError()
    }

    @Test
    fun `number one input null`() {
        //init
        val mCalcPresenter = CalculatePresenter(CalculateModel(CalculateRepository(mContext)), mView)

        mCalcPresenter.calc("10", "")
        Mockito.verify<CalculateBridge.View>(mView).addError()
    }

    @Test
    fun `number two input null`() {
        //init
        val mCalcPresenter = CalculatePresenter(CalculateModel(CalculateRepository(mContext)), mView)

        mCalcPresenter.calc("", "10")
        Mockito.verify<CalculateBridge.View>(mView).addError()
    }

    @Test
    fun `two input has data`() {
        //init
        val successAns = "20"
        val mCalcPresenter = CalculatePresenter(CalculateModel(CalculateRepository(mContext)), mView)

        mCalcPresenter.calc("10", "10")
        Mockito.verify<CalculateBridge.View>(mView).addSuccess(successAns)
    }

}
package keith.kotlinmvpdemo.presenter.calc

import android.content.Context
import keith.kotlinmvpdemo.config.Model.repository.CacheRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.powermock.modules.junit4.PowerMockRunner


@RunWith(PowerMockRunner::class)

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
        val mCalcPresenter = CalculatePresenter(CacheRepository(mContext), mView)

        mCalcPresenter.calc("", "")
        Mockito.verify<CalculateBridge.View>(mView).addError()
    }

    @Test
    fun `number one input null`() {
        //init
        val mCalcPresenter = CalculatePresenter(CacheRepository(mContext), mView)

        mCalcPresenter.calc("10", "")
        Mockito.verify<CalculateBridge.View>(mView).addError()
    }

    @Test
    fun `number two input null`() {
        //init
        val mCalcPresenter = CalculatePresenter(CacheRepository(mContext), mView)

        mCalcPresenter.calc("", "10")
        Mockito.verify<CalculateBridge.View>(mView).addError()
    }

    @Test
    fun `two input has data`() {
        //init
        val mModel = CacheRepository(mContext)

        val successAns = "20"
        val mCalcPresenter = CalculatePresenter(mModel, mView)

        mCalcPresenter.calc("10", "10")
        Mockito.verify<CalculateBridge.View>(mView).addSuccess(successAns)
    }

}
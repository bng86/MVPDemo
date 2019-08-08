package keith.kotlinmvpdemo.presenter.calc

import keith.kotlinmvpdemo.model.CalculateModel
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


class CalculatePresenterTest {

    private lateinit var presenter: CalculatePresenter
    private val view: CalculateBridge.View = mock(CalculateBridge.View::class.java)
    private val model: CalculateModel = mock(CalculateModel::class.java)

    @Before
    fun setup() {
        presenter = CalculatePresenter(model, view)
    }

    @Test
    fun `two number input null`() {
        presenter.calc("", "")
        verify(view).addError()
    }

    @Test
    fun `number one input null`() {
        presenter.calc("10", "")
        verify(view).addError()
    }

    @Test
    fun `number two input null`() {
        presenter.calc("", "10")
        verify(view).addError()
    }

    @Test
    fun `two input has data`() {
        //init
        val successAns = "20"
        presenter.calc("10", "10")
        verify(view).addSuccess(successAns)
        verify(model).setLastData(successAns.toLong())
    }

}
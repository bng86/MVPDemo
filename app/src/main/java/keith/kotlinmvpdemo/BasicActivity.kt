package keith.kotlinmvpdemo

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import android.widget.Toast

abstract class BasicActivity : AppCompatActivity() {

    private lateinit var mToast: Toast

    lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setViewContent()
        basicInit()
        setViewValue()
        setViewListener()
    }

    private fun basicInit() {
        mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT)
        mContext = this
        viewInit()
    }

    abstract fun setViewContent()

    abstract fun viewInit()

    abstract fun setViewValue()

    abstract fun setViewListener()

    fun showToast(str: String, isLong: Boolean) {
        mToast.cancel()

        mToast = Toast.makeText(mContext, str, if (isLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT)

        mToast.show()
    }

    fun setStatusBarHide() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    fun setActionBarHide() {
        if (supportActionBar != null)
            supportActionBar!!.hide()
    }

}
package com.catatanjalu.korean.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.catatanjalu.korean.R
import com.catatanjalu.korean.ui.dashboard.DashboardActivity

class SplashScreenActivity : AppCompatActivity() {

    private var handler: Handler? = null
    private val delay: Long = 2000
    private val runnable: Runnable = Runnable {
        if (!isFinishing) {
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        initView()
    }

    private fun initView() {
        openActivity()
    }

    private fun openActivity() {
        handler = Handler()
        handler!!.postDelayed(runnable, delay)
    }

    override fun onDestroy() {
        if (handler != null) {
            handler!!.removeCallbacks(runnable)
        }
        super.onDestroy()
    }
}

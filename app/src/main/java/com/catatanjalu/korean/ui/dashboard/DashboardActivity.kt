package com.catatanjalu.korean.ui.dashboard

import android.os.Build
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.catatanjalu.korean.R
import com.catatanjalu.korean.model.Dashboard
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class DashboardActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val dashboardList = mutableListOf<Dashboard>()
    private val dashboardAdapter = DashboardAdapter(dashboardList, this::onClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        initView()
    }


    private fun initView() {
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.overflowIcon = getDrawable(R.drawable.ic_menu_share_white)
        }

        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        title = "Home"
        getData()

        rvDashboard.run {
            layoutManager = LinearLayoutManager(this@DashboardActivity)
            adapter = dashboardAdapter
        }
    }

    private fun getData() {
        val image = listOf(
            R.drawable.game,
            R.drawable.gif,
            R.drawable.keyboard,
            R.drawable.lyric,
            R.drawable.music,
            R.drawable.sticker,
            R.drawable.video,
            R.drawable.wallpaper
        )

        val title = listOf(
            "Game",
            "Gif",
            "Keyboard",
            "Lyric",
            "Music",
            "Sticker",
            "Video",
            "Wallpaper"
        )

        val desc = listOf(
            "Guest the name of song",
            "Animated Twice's pictures",
            "Beautiful keyboard wallpaper",
            "Lyric song of Twice",
            "Enjoy all Twice's Songs",
            "Twice sticker & emoticon",
            "Video related to Twice",
            "HD wallpaper for your smartphone"
        )

        (0..7).forEach {
            val data = Dashboard(image[it], title[it], desc[it])
            dashboardList.add(data)
        }
    }

    private fun onClick(dashboard: Dashboard) {

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {

            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_tools -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}

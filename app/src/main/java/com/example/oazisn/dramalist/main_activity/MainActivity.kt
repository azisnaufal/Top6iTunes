package com.example.oazisn.dramalist.main_activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.oazisn.dramalist.R
import com.example.oazisn.dramalist.dao.TrendingItem
import com.example.oazisn.dramalist.utils.ApiClient
import com.example.oazisn.dramalist.utils.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    override fun showData(mValues: List<TrendingItem>) {
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = MainActivityRVAdapter(mValues)
    }

    private var presenter: MainPresenter =
        MainPresenter(this, ApiClient.getClient().create(ApiInterface::class.java))

    override fun showLoading() {
        refresh.setColorSchemeResources(
            R.color.colorAccent,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light
        )
        refresh.setOnRefreshListener {
            presenter.getData("us", "itunes", "singles")
        }
        refresh.isRefreshing = true
    }

    override fun hideLoading() {
        refresh.isRefreshing = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showLoading()
        presenter.getData("us", "itunes", "singles")
    }
}

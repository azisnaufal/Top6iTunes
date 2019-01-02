package com.example.oazisn.dramalist.main_activity

import com.example.oazisn.dramalist.dao.TrendingItem

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showData(mValues: List<TrendingItem>)
}
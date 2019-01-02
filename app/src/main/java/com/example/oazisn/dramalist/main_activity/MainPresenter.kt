package com.example.oazisn.dramalist.main_activity

import com.example.oazisn.dramalist.utils.ApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenter(private var view: MainView?, val apiInterface: ApiInterface) {
    fun getData(country: String, type: String, format: String) {
        apiInterface.getTrending(country, type, format)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .unsubscribeOn(Schedulers.io())
            .subscribe {
                view?.showData(it.trending!!)
                view?.hideLoading()
            }
    }
}
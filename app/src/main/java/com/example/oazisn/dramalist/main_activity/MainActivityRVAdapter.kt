package com.example.oazisn.dramalist.main_activity

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.oazisn.dramalist.R
import com.example.oazisn.dramalist.dao.TrendingItem
import kotlinx.android.synthetic.main.activity_main_rv_item.view.*

class MainActivityRVAdapter(private val mValues: List<TrendingItem>) :
    RecyclerView.Adapter<MainActivityRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context)
            .inflate(R.layout.activity_main_rv_item, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mValues.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val item: TrendingItem = mValues.get(mValues.size - p1 - 1)

        Glide.with(p0.mView.context)
            .load(item.strTrackThumb)
            .into(p0.mView.ivAlbumArt)

        p0.mView.tvArtist.text = item.strArtist
        p0.mView.tvPosition.text = item.intChartPlace
        p0.mView.tvTitle.text = item.strTrack
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView)
}
package com.catatanjalu.korean.ui.dashboard

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.catatanjalu.korean.R
import com.catatanjalu.korean.model.Dashboard
import kotlinx.android.synthetic.main.item_dashboard.view.*

class DashboardAdapter(
    private val dashboardList: List<Dashboard>,
    private val onClick: (dashboard: Dashboard) -> Unit
) : RecyclerView.Adapter<DashboardAdapter.DashboardHolder>() {
    override fun onCreateViewHolder(group: ViewGroup, type: Int): DashboardHolder {
        val inflater = LayoutInflater.from(group.context)
        return DashboardHolder(inflater.inflate(R.layout.item_dashboard, group, false))
    }

    override fun getItemCount(): Int = dashboardList.size

    override fun onBindViewHolder(holder: DashboardHolder, position: Int) {
        val dashboard = dashboardList[position]

        holder.bind(dashboard).run {
            setOnClickListener {
                onClick(dashboard)
            }
        }
    }

    inner class DashboardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(dashboard: Dashboard) = itemView.apply {
            Glide
                .with(context)
                .load(dashboard.icon)
                .into(ivMenu)

            tvMenu.text = dashboard.title
            tvDesc.text = dashboard.shortDescription
        }
    }
}
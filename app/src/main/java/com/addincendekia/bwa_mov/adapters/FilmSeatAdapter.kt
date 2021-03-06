package com.addincendekia.bwa_mov.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.addincendekia.bwa_mov.R
import com.addincendekia.bwa_mov.models.FilmSeat

class FilmSeatAdapter(private val filmSeatData: List<FilmSeat>) : RecyclerView.Adapter<FilmSeatAdapter.SeatViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null

    interface OnItemClickCallback {
        fun onItemClicked(filmSeat: FilmSeat, position: Int)
    }

    class SeatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivSeat: ImageView = itemView.findViewById(R.id.iv_topup_option)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeatViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycleview_filmseat, parent, false)
        return SeatViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filmSeatData.size
    }

    override fun onBindViewHolder(holder: FilmSeatAdapter.SeatViewHolder, position: Int) {
        val filmSeat = filmSeatData[position]
        var seatSate = R.drawable.movie_seat_empty

        if(filmSeat.status!! == 1) seatSate = R.drawable.movie_seat_booked
        else if (filmSeat.status!! == 2) seatSate = R.drawable.movie_seat_selected

        holder.ivSeat.setImageResource(seatSate)
        holder.itemView.setOnClickListener { onItemClickCallback?.onItemClicked(filmSeat, position) }
    }

    fun setOnItemClickCallback(onItemClickCallback: FilmSeatAdapter.OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

}

package com.android.final_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Kelas adapter untuk RecyclerView, menangani data InventoryItem
class InventoryAdapter(
    private val items: List<InventoryItem>,
    private val onClick: (InventoryItem) -> Unit
) : RecyclerView.Adapter<InventoryAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Mendapatkan referensi TextView dari layout item_inventory
        val tvNama: TextView = view.findViewById(R.id.tvItemNama) // TextView untuk Nama Item
        val tvStok: TextView = view.findViewById(R.id.tvItemStok) // TextView untuk Stok Item
        val tvSatuan: TextView = view.findViewById(R.id.tvItemSatuan) // TextView untuk Satuan Item
    }

    // Dipanggil saat RecyclerView membutuhkan ViewHolder baru
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_inventory, parent, false)
        return ViewHolder(view)
    }

    // Dipanggil oleh RecyclerView untuk menampilkan data pada posisi tertentu
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        // Mengatur teks di TextView sesuai dengan data item
        holder.tvNama.text = item.namaBahan
        holder.tvStok.text = "Stok: ${item.stok}"
        holder.tvSatuan.text = item.satuan

        // Menetapkan listener klik pada seluruh item View
        holder.itemView.setOnClickListener { onClick(item) }
    }

    // Mengembalikan jumlah total item dalam daftar
    override fun getItemCount() = items.size
}
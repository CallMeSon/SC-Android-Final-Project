package com.android.final_project

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.final_project.databinding.ActivityHomepageBinding

class HomepageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomepageBinding
    private lateinit var adapter: InventoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari Intent (Parcelable)
        val userLogin: Akun? = intent.getParcelableExtra("DATA_USER")

        if (userLogin != null) {
            // Mengakses TextView 'tvWelcome' yang dibuat di XML tadi
            binding.tvWelcome.text = "Halo, ${userLogin.accName}!"
        }

        // Setup RecyclerView
        binding.rvInventory.layoutManager = LinearLayoutManager(this)

        // Tombol Tambah Barang
        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        // Refresh data saat kembali ke halaman ini
        setupList()
    }

    private fun setupList() {
        // 1. Ambil data mentah
        val rawList = MockData.inventoryList

        // 2. Advanced Collection Function: sortedBy
        val sortedList = rawList.sortedBy { it.namaBahan }

        // 3. Gunakan daftar yang sudah disortir untuk Adapter
        adapter = InventoryAdapter(sortedList) { item ->
            // Saat item diklik, pindah ke FormActivity untuk Edit
            val intent = Intent(this, FormActivity::class.java)
            intent.putExtra("ITEM_ID", item.idBahan)
            startActivity(intent)
        }
        binding.rvInventory.adapter = adapter
    }
}
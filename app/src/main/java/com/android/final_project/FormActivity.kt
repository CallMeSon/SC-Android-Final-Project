package com.android.final_project

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.final_project.databinding.ActivityFormBinding


class FormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding
    private var itemId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cek apakah ini Mode Edit (ada ID yang dikirim)
        if (intent.hasExtra("ITEM_ID")) {
            itemId = intent.getIntExtra("ITEM_ID", -1)
            val item = MockData.inventoryList.find { it.idBahan == itemId }

            if (item != null) {
                // Isi form dengan data lama
                binding.tvFormTitle.text = "Edit Barang"
                binding.etNama.setText(item.namaBahan)
                binding.etStok.setText(item.stok.toString())
                binding.etSatuan.setText(item.satuan)
                binding.btnDelete.visibility = View.VISIBLE
            }
        }

        // Logic Tombol Simpan
        binding.btnSave.setOnClickListener {
            val nama = binding.etNama.text.toString()
            val stok = binding.etStok.text.toString().toIntOrNull() ?: 0
            val satuan = binding.etSatuan.text.toString()

            if (nama.isNotEmpty()) {
                if (itemId == -1) {
                    // CREATE
                    MockData.tambahItem(nama, stok, satuan)
                    Toast.makeText(this, "Item Ditambahkan", Toast.LENGTH_SHORT).show()
                } else {
                    // UPDATE
                    MockData.ubahItem(itemId, nama, stok, satuan)
                    Toast.makeText(this, "Item Diupdate", Toast.LENGTH_SHORT).show()
                }
                finish() // Kembali ke Homepage
            } else {
                Toast.makeText(this, "Nama harus diisi", Toast.LENGTH_SHORT).show()
            }
        }

        // Logic Tombol Hapus
        binding.btnDelete.setOnClickListener {
            MockData.hapusItem(itemId)
            Toast.makeText(this, "Item Dihapus", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
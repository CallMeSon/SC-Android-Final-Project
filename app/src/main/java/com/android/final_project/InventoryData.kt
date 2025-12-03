package com.android.final_project

// TEMPAT PENYIMPANAN DATA BAHAN

//Tempat menyimpan data Item

data class InventoryItem(
    val idBahan: Int,
    var namaBahan: String,
    var stok: Int,
    var satuan: String,
)

// Tempat memasukan data serta logical code (Create, Update, Delete)
object MockData {
    val inventoryList = mutableListOf(
        InventoryItem(1, "Tepung", 100, "kg"),
        InventoryItem(2, "Minyak", 50, "liter")
    )

    private val nextId = 3

//Logical untuk tambah item
    fun tambahItem(namaBahan: String, stok: Int, satuan: String) {
        inventoryList.add(InventoryItem(nextId, namaBahan, stok, satuan))
    }

//    Logical update bahan
    fun ubahItem(idBahan: Int, namaBahan: String, stok: Int, satuan: String) {
        val index = inventoryList.indexOfFirst { it.idBahan == idBahan }
        if (index != -1) {
            inventoryList[index] = InventoryItem(idBahan, namaBahan, stok, satuan)
        }
    }

//    Logical delete item
    fun hapusItem(idBahan: Int) {
        inventoryList.removeIf { it.idBahan == idBahan }
    }
}



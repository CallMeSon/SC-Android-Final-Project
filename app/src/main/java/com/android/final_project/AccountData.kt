package com.android.final_project

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// 1. DATA MODEL (Dengan Parcelable)
@Parcelize
data class Akun(
    val accName: String,
    val accPass: String,
    val role: String = "User" // menambahkan role
) : Parcelable

// 2. ENCAPSULATION (Data Source)
object AccountRepository {
    // Data list bersifat PRIVATE (Encapsulation), tidak bisa diakses langsung dari luar
    private val daftarAkun = listOf(
        Akun("admin", "admin123", "Administrator"),
        Akun("kasir", "kasir123", "Staff")
    )

    // Fungsi Public untuk memvalidasi login
    // Activity hanya memanggil ini tanpa perlu tahu cara kerjanya
    fun cekLogin(username: String, password: String): Akun? {
        val akunDitemukan = daftarAkun.find {
            it.accName.equals(username, ignoreCase = true)
        }

        return akunDitemukan?.let {
            if (it.accPass == password) {
                it
            } else {
                null // Jika password salah, kembalikan null
            }
        }
    }
}
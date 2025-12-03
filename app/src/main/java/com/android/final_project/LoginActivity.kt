package com.android.final_project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.final_project.databinding.LoginPageBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Memastikan login Activity berjalan
        Log.d("LoginActivity", "onCreate dipanggil")

        binding.loginButton.setOnClickListener {
            val inputUsername = binding.username.text.toString()
            val inputPassword = binding.password.text.toString()

            Log.d("LoginActivity", "Tombol Login diklik.")
            Log.d("LoginActivity", "Username Input: $inputUsername")

            // Memanggil logika dari file AccountData.kt (Encapsulation)
            val akunBerhasil: Akun? = AccountRepository.cekLogin(inputUsername, inputPassword)

            if (akunBerhasil != null) {
                // Login Sukses
                val intent = Intent(this, HomepageActivity::class.java)

                // MENGGUNAKAN PARCELABLE: Mengirim seluruh objek 'akunBerhasil'
                intent.putExtra("DATA_USER", akunBerhasil)

                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Login Gagal! Cek Username/Password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
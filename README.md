# 📦 Inventory Management System

![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-purple?logo=kotlin&logoColor=white)
![Android SDK](https://img.shields.io/badge/MinSDK-24-green?logo=android)
![Status](https://img.shields.io/badge/Status-Final%20Project-blue)

> **SC Android Final Project** > Aplikasi manajemen stok barang sederhana yang efisien, bersih, dan mudah digunakan.

---

## 📱 Tentang Aplikasi

**Inventory Management System** adalah aplikasi Android native yang dirancang untuk mempermudah proses pencatatan stok barang. Aplikasi ini memungkinkan pengguna untuk melihat daftar barang, menambah stok baru, mengubah data, dan menghapus barang yang sudah tidak diperlukan (CRUD).

Proyek ini dibangun sebagai tugas akhir (*Final Project*) dengan fokus pada implementasi **RecyclerView**, **Intent Parcelable**, dan **Manajemen Data Sederhana (In-Memory)**.

---

## ✨ Fitur Utama

✅ **Sistem Login Autentikasi** Mendukung login dengan validasi username dan password. Dilengkapi dengan *Role* (Administrator & Staff).

✅ **Dashboard Inventaris** Tampilan daftar barang yang rapi menggunakan `RecyclerView`.

✅ **CRUD (Create, Read, Update, Delete)** * **Tambah Barang:** Form intuitif untuk input nama, stok, dan satuan.
* **Edit Barang:** Ubah data stok atau nama barang dengan mudah.
* **Hapus Barang:** Hapus item dari daftar inventaris.

✅ **Desain UI Menarik** Menggunakan komponen Material Design dengan sentuhan warna kustom (*Purple Theme*) dan *custom drawable backgrounds*.

---

## 🛠️ Teknologi yang Digunakan

* **Bahasa Pemrograman:** [Kotlin](https://kotlinlang.org/)
* **UI Toolkit:** XML Layouts & Material Components
* **Architecture:** MVC (Model-View-Controller) pattern
* **Komponen Android:**
    * `RecyclerView` (untuk menampilkan list data)
    * `ViewBinding` (untuk interaksi UI yang aman)
    * `Intent & Parcelable` (untuk pengiriman data antar Activity)
    * `Toast` (untuk notifikasi user)

---

## 🔐 Akun Demo (Credentials)

Karena aplikasi ini menggunakan *local data repository* untuk login, silakan gunakan akun berikut untuk masuk ke dalam aplikasi:

| Role | Username | Password |
| :--- | :--- | :--- |
| **Administrator** | `admin` | `admin123` |
| **Staff (Kasir)** | `kasir` | `kasir123` |

---

## 🚀 Cara Menjalankan Project

1.  **Clone Repository**
    ```bash
    git clone [https://github.com/username-kamu/SC-Android-Final-Project.git](https://github.com/username-kamu/SC-Android-Final-Project.git)
    ```
2.  **Buka di Android Studio**
    * Buka Android Studio.
    * Pilih **Open** dan arahkan ke folder project yang baru di-clone.
3.  **Sync Gradle**
    * Tunggu hingga proses *Gradle Sync* selesai (pastikan koneksi internet lancar).
4.  **Run App**
    * Hubungkan HP Android atau gunakan Emulator.
    * Tekan tombol ▶️ **Run**.

---

## 📂 Struktur Project

```text
com.android.final_project
├── 📂 databinding       # Generated bindings
├── 📄 AccountData.kt    # Model Akun & Repository Login (Hardcoded Data)
├── 📄 FormActivity.kt   # Logika Halaman Tambah/Edit
├── 📄 HomepageActivity.kt # Logika Halaman Utama & List
├── 📄 InventoryAdapter.kt # Adapter untuk RecyclerView
├── 📄 InventoryData.kt  # Model Barang & Mock Data Source
└── 📄 LoginActivity.kt  # Logika Halaman Login

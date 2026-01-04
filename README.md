# P7 - Modern UI Implementation (Material Design 3) 📱

Repository ini berisi source code untuk **Modul Praktikum #7 Mobile Programming 20251**. Project ini berfokus pada penerapan desain antarmuka modern menggunakan **Jetpack Compose** dan **Material Design 3**.

## 🎯 Topik Praktikum
**"Menerapkan Desain UI Modern"**
* **Dosen Pengampu:** Muhayat, M.IT
* **Topik:** Material Design 3, Theming, Custom Components, & Dark Mode.

---

## ✨ Fitur Utama

Aplikasi ini telah dimodernisasi dengan fitur-fitur berikut:

### 1. Desain UI Modern (Material 3) 🎨
* Menggunakan **Color Scheme Professional (Blue)** menggantikan warna default.
* Implementasi **Typography** dan **Shapes** (Rounded Corners) yang konsisten.
* Komponen UI kustom: `AppButton`, `AppTextField`, dan `AppCard`.

### 2. Struktur Navigasi Lengkap navigasi 🧭
Aplikasi memiliki 4 halaman utama yang saling terhubung:
* **Login Screen:** UI Login modern dengan akses cepat Biometric.
* **Home Screen:** Dashboard dengan card status dan aktivitas.
* **Profile Screen:** Halaman profil pengguna.
* **Settings Screen:** Pengaturan aplikasi.

### 3. Dark Mode & Light Mode bulan/matahari 
* Mendukung tema Gelap dan Terang secara native.
* Terdapat **Toggle Switch** di halaman Settings untuk mengubah tema secara manual (tanpa harus ubah settingan HP).

### 4. Fitur Keamanan (UI Simulation) 🔒
* **Biometric Login:** Tombol akses cepat fingerprint di halaman login.
* **Privacy Settings:** Toggle untuk App Lock dan Biometric Authentication di halaman Settings.

---

## 📸 Screenshots
![Screenshot_2026-01-05-03-53-24-205_id antasari p7_230104040203_pm](https://github.com/user-attachments/assets/9a4714d9-4e74-4c4d-aa75-1553044e7070)
![Screenshot_2026-01-05-03-53-33-675_id antasari p7_230104040203_pm](https://github.com/user-attachments/assets/dee383de-a6d6-4bb0-85c8-24d7e267eeef)
![Screenshot_2026-01-05-03-53-59-734_id antasari p7_230104040203_pm](https://github.com/user-attachments/assets/d88f9029-8f78-4dc2-a1e0-ba530525d7f5)
![Screenshot_2026-01-05-03-54-03-939_id antasari p7_230104040203_pm](https://github.com/user-attachments/assets/cbb5331a-909d-43ea-bdf7-a4bc1ac435e3)
![Screenshot_2026-01-05-03-54-06-670_id antasari p7_230104040203_pm](https://github.com/user-attachments/assets/09e68a76-da0a-42e3-a9e6-cabf966d5ec1)
![Screenshot_2026-01-05-03-54-08-194_id antasari p7_230104040203_pm](https://github.com/user-attachments/assets/a0745264-7ca4-4799-ae89-3c258d043bcb)
![Screenshot_2026-01-05-03-54-10-549_id antasari p7_230104040203_pm](https://github.com/user-attachments/assets/d6c19e4a-b816-43e8-95ec-747e511ca587)
![Screenshot_2026-01-05-03-54-13-351_id antasari p7_230104040203_pm](https://github.com/user-attachments/assets/0f91915d-2781-4e0b-ae7a-327af0b1b029)



---

## 🛠️ Tech Stack

* **Language:** Kotlin
* **UI Toolkit:** Jetpack Compose (BOM 2024+)
* **Design System:** Material Design 3
* **Navigation:** AndroidX Navigation Compose
* **Icons:** Material Icons Extended

---

## 📂 Struktur Project

```text
id.antasari.p7_230104040203_pm
├── ui
│   ├── auth          # AuthViewModel, AuthUiState
│   ├── components    # Reusable (AppButton, AppTextField, AppCard)
│   ├── navigation    # AppNavHost (Nav Graph)
│   └── theme         # Color, Type, Shape, Theme (M3)
├── BiometricUtils.kt # Utility helper
├── HomeScreen.kt     # Halaman Dashboard
├── LoginScreen.kt    # Halaman Login
├── ProfileScreen.kt  # Halaman Profil
├── SettingsScreen.kt # Halaman Pengaturan
└── MainActivity.kt   # Entry Point
```

## 👤 Identitas Mahasiswa
* **Nama**: Nor Hayati
* **NIM**: 230104040203
* **Kelas**: Mobile Programming TI23A
* **Kampus**: Universitas Islam Negeri Antasari Banjarmasin
---

### AP3 - Character Manager (Java Visual SIH-6406)
Aplikasi ini adalah sistem manajemen karakter sederhana berbasis teks (Console-based Game Character Manager) yang dibangun menggunakan bahasa pemrograman Java. Proyek ini menerapkan prinsip Pemrograman Berorientasi Objek (OOP), khususnya enkapsulasi (Encapsulation) dengan pembatasan hak akses atribut menggunakan setter, getter, serta fungsi validasi nilai logika. Sistem juga mendukung kalkulasi otomatis status karakter (HP dan Attack) berdasarkan level serta fitur pelacakan kondisi hidup/mati karakter.

## Screenshot Output Terminal ap3
![Bukti_Ap_3](Bukti_Ap_3.png)

Struktur Folder Project

Screenshot ini mendokumentasikan demo sebelumnya yang menampilkan hasil isAlive(). Main.java sekarang menjalankan demo CRUD v0.2.


### Struktur Project
CharacterMaager_/
├── src/
│   ├── Main.java
│   └── com/
│       └── unpri/
│           └── charactermanager/
│               └── model/
│                   ├── Character.java
│                   ├── CharacterManager.java
│                   └── CharacterType.java
├── Bukti_Tp_3.png
│── Bukti_Tp_6.png
└── README.md


### AP6 - Fitur Baru: Pencarian Karakter Terkuat (findStrongest)
Rasional / Alasan Fitur Dalam pengembangan sebuah game atau sistem RPG, mengetahui entitas atau karakter mana yang memiliki statistik tertinggi (terkuat) merupakan fitur analisis data yang sangat krusial. Fitur findStrongest() ditambahkan untuk mempermudah sistem dalam menyaring karakter dengan daya serang (attackPower) paling mendominasi tanpa mengharuskan layer aplikasi melakukan pengurutan (sorting) manual di sisi luar.

Menjaga Prinsip OOP & Enkapsulasi Defensive Design: Method mengembalikan satu objek Character tunggal atau nilai null apabila sistem belum memiliki data karakter sama sekali. No Information Leakage: Struktur data internal ArrayList characterList milik CharacterManager tetap terkunci rapat di dalam class (private). Akses luar murni hanya mendapatkan hasil kalkulasi/pencarian objek spesifik tanpa diberi celah untuk memodifikasi atau menambah isi list secara ilegal.

## screenshot Output Terminal Ap6
![Bukti_Ap_6](Bukti_Ap_6.png)

### AP10 — Character Manager GUI dan Statistik Karakter
Aliran Data dan Penerapan MVC Aliran data aplikasi dimulai dari Main.java, yang membuat objek Character dan menambahkan data karakter ke CharacterManager. Selanjutnya, Main.java mengambil daftar karakter melalui method getAllCharacters() dan mengirimkannya ke MainWindow untuk ditampilkan dalam antarmuka Java Swing. Dalam konsep MVC, package model bertanggung jawab terhadap data dan logika karakter, sedangkan MainWindow berperan sebagai bagian View yang menampilkan data kepada pengguna. Main.java mengatur proses inisialisasi dan menghubungkan Model dengan View, sementara statistik rata-rata level dihitung berdasarkan daftar karakter yang diterima oleh View.

Karakter Baru dan Alasan Pemilihan Tipe/Level Dua karakter baru ditambahkan untuk memenuhi kebutuhan minimal lima karakter sekaligus memberikan variasi tipe dan level pada aplikasi. Srikandi — ARCHER, Level 2: Dipilih sebagai karakter pemanah dengan level awal yang relatif rendah untuk menunjukkan variasi statistik pada karakter yang masih berkembang. Bima — WARRIOR, Level 6: Dipilih sebagai karakter petarung dengan level lebih tinggi untuk memberikan perbandingan statistik dengan karakter berlevel rendah serta membantu menguji perhitungan rata-rata level. Penambahan karakter dengan tipe dan level yang berbeda memungkinkan aplikasi menampilkan data yang lebih bervariasi dan menguji apakah statistik rata-rata level dihitung berdasarkan seluruh karakter secara akurat.

## Screenshot Output Terminal ap10 
![Bukti_Ap_10](Bukti_Ap_10.png)

### AP13 — Dokumentasi Pembaruan GUI & Manajemen Tema
## 1. Rasionalisasi Pemisahan Data Warna (AppTheme vs Character)
Penyimpanan data warna dikelola secara terpusat di dalam kelas AppTheme (atau AppThema) dan bukan di dalam kelas Character demi menjaga prinsip Separation of Concerns (Pemisahan Tanggung Jawab) pada arsitektur MVC. Kelas Character murni bertindak sebagai Model yang hanya bertanggung jawab atas logika data dan status internal karakter seperti nama, level, atau poin kesehatan. Jika warna dimasukkan ke dalam kelas Character, hal tersebut akan merusak enkapsulasi karena memaksa komponen Model untuk memahami elemen visual grafis yang merupakan ranah penuh dari komponen View. Dengan pendekatan ini, perubahan tema visual seluruh aplikasi di masa mendatang dapat dilakukan dengan cepat hanya melalui satu file konfigurasi saja tanpa berisiko merusak logika bisnis inti.

## 2. Daftar Properti Tambahan Visual dan Alasan Pemilihan
Untuk meningkatkan kualitas antarmuka dan pengalaman pengguna (UX), berikut adalah dua properti tambahan yang disematkan ke dalam kartu komponen GUI:

Restriksi Akses Karakter Pemula (setEnabled(false))
Alasan: Properti ini dipilih untuk memberikan indikasi visual yang kuat terhadap status kesiapan karakter. Karakter berlevel 1 dianggap sebagai entitas pemula (trainee) yang belum memiliki kapabilitas bertarung, sehingga komponen visualnya sengaja dinonaktifkan untuk menyimulasikan pembatasan akses interaksi dalam sistem permainan.
Mekanisme Informasi Melayang (Dynamic HTML Tooltip)
Alasan: Properti ini diimplementasikan untuk mempertahankan estetika jendela aplikasi agar tetap bersih, minimalis, dan ringkas. Rincian status sekunder yang padat seperti daya tahan (hitPoints) dan daya serang (attackPower) dipindahkan ke dalam hover tooltip berformat HTML sehingga pengguna tetap dapat meninjau statistik mendalam tanpa membuat tata letak utama menjadi penuh sesak.
## Screenshot Output (sebelum vs sesudah)
# Sesudah
![Bukti_Ap13_sesudah](Bukti_Ap13_sesudah.png)
# Sebelum
![Bukti_Ap13_sebelum](Bukti_Ap13_sebelum.png)

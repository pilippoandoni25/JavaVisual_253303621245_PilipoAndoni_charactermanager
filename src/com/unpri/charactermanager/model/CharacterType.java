package com.unpri.charactermanager.model; // deklarasi package, harus baris pertama (kecuali komentar)

/**
 * Enum yang mendefinisikan jenis-jenis karakter dalam aplikasi.
 * Menggunakan enum (bukan String) agar nilai selalu valid dan type-safe.
 */
public enum CharacterType {
    WARRIOR, // karakter pejuang — HP & attack tinggi
    MAGE,    // karakter penyihir — attack tinggi, HP rendah
    ARCHER,  // karakter pemanah — seimbang, attack jarak jauh
    HEALER   // karakter penyembuh — HP tinggi, attack rendah
}
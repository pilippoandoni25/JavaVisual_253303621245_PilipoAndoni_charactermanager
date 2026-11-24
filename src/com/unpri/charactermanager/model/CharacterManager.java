package com.unpri.charactermanager.model;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Mengelola koleksi Character: tambah, cari, hapus, dan statistik dasar.
 * Menerapkan Composition: CharacterManager "has-a" ArrayList<Character>.
 */
public class CharacterManager {

    private ArrayList<Character> characterList;

    public CharacterManager() {
        this.characterList = new ArrayList<>(); // list kosong saat manager pertama dibuat
    }

    /**
     * Menambahkan karakter baru ke dalam list.
     * Menolak jika sudah ada karakter dengan nama yang sama.
     * @return true jika berhasil ditambahkan, false jika ditolak karena duplikat
     */
    public boolean addCharacter(Character character) {
        if (isNameTaken(character.getName())) {
            System.out.println("❌ Gagal: karakter dengan nama '" + character.getName() + "' sudah ada!");
            return false;
        }
        characterList.add(character);
        System.out.println("✅ Karakter '" + character.getName() + "' berhasil ditambahkan.");
        return true;
    }

    public Character findByName(String name) {
        for (Character character : characterList) {
            if (Objects.equals(character.getName(), name)) {
                return character;
            }
        }
        return null;
    }

    public boolean removeCharacter(String name) {
        Character character = findByName(name);
        if (character == null) {
            System.out.println("❌ Gagal: karakter dengan nama '" + name + "' tidak ditemukan.");
            return false;
        }
        characterList.remove(character);
        System.out.println("✅ Karakter '" + name + "' berhasil dihapus.");
        return true;
    }

    public int getTotalCharacters() {
        return characterList.size();
    }

    public double getAverageLevel() {
        if (characterList.isEmpty()) {
            return 0.0;
        }

        double totalLevels = 0.0;
        for (Character character : characterList) {
            totalLevels += character.getLevel();
        }
        return totalLevels / characterList.size();
    }

    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> matches = new ArrayList<>();
        for (Character character : characterList) {
            if (character.getType() == type) {
                matches.add(character);
            }
        }
        return matches;
    }

    /** Mengembalikan true jika sudah ada karakter bernama sama (tanpa membedakan huruf besar/kecil). */
    public boolean isNameTaken(String name) {
        for (Character c : getAllCharacters()) {
            if (c.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characterList);
    }
}
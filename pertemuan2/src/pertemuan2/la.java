/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan2;

/**
 *
 * @author wadda
 */
public class la {
        // Kelas Hewan
    static class Hewan {
        private String nama;
        private int energi;

        // Konstruktor
        public Hewan(String nama, int energi) {
            this.nama = nama;
            this.energi = energi;
        }

        // Getter untuk nama
        public String getNama() {
            return nama;
        }

        // Getter untuk energi
        public int getEnergi() {
            return energi;
        }

        // Method untuk berjalan
        public void berjalan() {
            if (energi >= 5) {
                energi -= 5;
                System.out.println(nama + " berjalan, energi sekarang: " + energi);
            } else {
                System.out.println(nama + " tidak memiliki cukup energi untuk berjalan!");
            }
        }

        // Method untuk makan
        public void makan() {
            energi += 4;
            System.out.println(nama + " makan, energi sekarang: " + energi);
        }
    }

    // Kelas Utama
    public static void main(String[] args) {
        Hewan kucing = new Hewan("Kitty", 10);
        Hewan anjing = new Hewan("Buddy", 8);

        kucing.berjalan(); // Kitty berjalan, energi berkurang 5
        kucing.makan();    // Kitty makan, energi bertambah 4
        anjing.berjalan(); // Buddy berjalan, energi berkurang 5
        anjing.makan();    // Buddy makan, energi bertambah 4
    }
}

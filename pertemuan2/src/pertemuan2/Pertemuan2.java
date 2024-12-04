/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pertemuan2;

/**
 *
 * @author wadda
 */
public class Pertemuan2 {

    // Base class
    static class Hewan {
        // Encapsulation
        private String nama;

        // Constructor
        public Hewan(String nama) {
            this.nama = nama;
        }

        // Getter for nama
        public String getNama() {
            return nama;
        }

        // Method for animal sound
        public void bersuara() {
            System.out.println("Hewan ini bersuara.");
        }
    }

    // Kelas turunan (inheritance)
    static class Kucing extends Hewan {
        // Constructor
        public Kucing(String nama) {
            super(nama); // Memanggil konstruktor kelas dasar
        }

        // Polymorphism
        @Override
        public void bersuara() {
            System.out.println(getNama() + " berkata: Meow!");
        }
    }

    // Kelas turunan lainnya
    static class Anjing extends Hewan {
        // Constructor
        public Anjing(String nama) {
            super(nama); // Memanggil konstruktor kelas dasar
        }

        // Polymorphism
        @Override
        public void bersuara() {
            System.out.println(getNama() + " berkata: Bark!");
        }
    }

    public static void main(String[] args) {
        Hewan kucing = new Kucing("Kitty");
        Hewan anjing = new Anjing("Buddy");

        kucing.bersuara();
        anjing.bersuara();
    }
}

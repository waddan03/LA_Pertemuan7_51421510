/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.parkiran.controller;

import com.parkiran.model.ModelParkiran;
import com.parkiran.repository.ParkiranRepository;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ParkiranController {
    
    @Autowired
    private ParkiranRepository parkiranRepository;
    
    public void tampilkanMenu(){
        Scanner scanner = new Scanner(System.in);
        int opsi;
        
        do{
            System.out.println("\n------ Menu parkiran ------");
            System.out.println("1. Masuk Parkir");
            System.out.println("2. Keluar Parkir");
            System.out.println("3. Exit Program");
            opsi = scanner.nextInt();
            scanner.nextLine();
            
            switch (opsi){
                case 1:
                    masukParkir(scanner);
                    break;
                case 2:
                    keluarParkir(scanner);
                    break;
                case 3:
                    System.out.println("keluar dari program");
                    break;
                default:
                        System.out.println("Opsi tidak valid");
            }
        } while (opsi != 3);
    }
    
    private void masukParkir(Scanner scanner) {
        System.out.println("Masuk plat Nomor: ");
        String platNomor = scanner.nextLine();
         System.out.println("Masukan Jenis Kendaraan: ");
        int jenisKendaraan = scanner.nextInt();
        
        ModelParkiran parkiran = new ModelParkiran(platNomor, LocalDateTime.now(), jenisKendaraan);
        parkiranRepository.save(parkiran);
        System.out.println("Berhasil disimpan!");
    }
    
    private void keluarParkir(Scanner scanner) {
        System.out.print("Masukkan Plat Nomor: ");
        String platNomor = scanner.nextLine();
        
        Optional<ModelParkiran> optionalParkiran = parkiranRepository.findByPlatNomor(platNomor);
        if (optionalParkiran.isPresent()) {
            ModelParkiran parkiran = optionalParkiran.get();
            LocalDateTime waktuKeluar = LocalDateTime.now();
            
            //Hitung durasi parkir
            Duration durasi = Duration.between(parkiran.getWaktuMasuk(), waktuKeluar);
            long jamParkir = durasi.toHours();
            if (durasi.toMinutesPart() > 0) {
                jamParkir++; //Pembulatan ke atas jika  ada menit lebih
            }
            
            //Hitung biaya parkir
            int tarifPerJam = (parkiran.getJenisKendaraan() == 1) ? 5000 : 10000;
            long totalBiaya = jamParkir * tarifPerJam;
            
            System.out.println("Waktu Masuk: " + parkiran.getWaktuMasuk());
            System.out.println("Waktu Keluar: " + waktuKeluar);
            System.out.println("Lama Parkir: " + jamParkir + " jam");
            System.out.println("Total Biaya Parkir: Rp " + totalBiaya);
            
            //Hapus Data parkir dari database setelah keluar
            parkiranRepository.delete(parkiran);
        } else {
            System.out.println("Kendaraan dengan plat nomor " + platNomor + " tidak ditemukan.");
        }
    }
}

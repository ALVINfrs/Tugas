import java.util.Scanner;


public class RestoranDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("========= PROGRAM KASIR TEMPAT MAKAN =========");
        
        System.out.print("Masukkan Nama Pelanggan : ");
        String nama = input.nextLine();
        
        System.out.print("Masukkan Nama Makanan   : ");
        String makanan = input.nextLine();
        
        System.out.print("Masukkan Jumlah Pesanan : ");
        int jumlah = input.nextInt();
        
        System.out.print("Masukkan Harga Satuan   : ");
        double harga = input.nextDouble();

      
        TempatMakan pesananSatu = new TempatMakan(nama, makanan, jumlah, harga);

        
        pesananSatu.tampilkanStruk();
        
        input.close();
    }
}
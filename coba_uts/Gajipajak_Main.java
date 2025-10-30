
import java.util.Scanner;

public class Gajipajak_Main extends Gajipajak {

    public Gajipajak_Main(int id , String namaKaryawan, double gaji ) {
        super(id, namaKaryawan,gaji);
    }
    

    public static void main(String[] args) {
       try (Scanner input = new Scanner(System.in)){


        System.out.println("Maukan ID Karyawan :  ");
        int id = input.nextInt();
        input.nextLine();

         System.out.println("Maukan Nama Karyawan :  ");
         String namaKarywan = input.nextLine();

          System.out.println("Maukan Gaji Pokok (Rp) :  ");
          double gaji = input.nextDouble();
           

          Gajipajak_Main karyawan = new Gajipajak_Main(id, namaKarywan, gaji);
          
          karyawan.hitungpajak();
          karyawan.totalgaji();
          karyawan.cetakInfo();
        
         System.out.println("\n=== DATA KARYAWAN ===");
         karyawan.cetakInfo();
         
          System.out.println("\n=== Perhitungan Gaji ===");
         karyawan.tampilkanGaji();
       }
        
        
    }
}

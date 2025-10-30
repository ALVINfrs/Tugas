
class Gajipajak{
    int id;
    String namakaryawan;
    double gaji;
    double pajak;
    double totalGaji;


    Gajipajak(int id, String namakaryawan, double gaji){
      this.id=id;
      this.namakaryawan=namakaryawan;
      this.gaji=gaji;
    }
     

    double hitungpajak(){
        pajak= gaji * 0.05;
        return pajak;
    }

    double totalgaji(){
        totalGaji= gaji-pajak;
        return totalGaji;
    }

    void tampilkanGaji(){
        System.out.printf("Gaji Pokok    : Rp %.2f\n",gaji);
        System.out.printf("Pajak (5%%)    : Rp %.2f\n", pajak);
        System.out.printf("Total Gaji     : Rp %.2f\n", totalGaji);     
    }

    void cetakInfo (){
        System.out.println("ID Karyawan : " + id);
         System.out.println("Nama Karyawan : " + namakaryawan);
    }

}
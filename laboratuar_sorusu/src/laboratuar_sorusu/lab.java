package laboratuar_sorusu;
import java.util.Scanner;
public class lab {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        String[] konular = {"Cevre Kirliligi", "Egitim", "Saglik", "Adalet", "Ekonomi"};
	        int[][] yanitlar = new int[5][10];
	        
	        System.out.print("Ankete katilacak kisi sayisini girin: ");
	        int kisiSayisi = scanner.nextInt();
	        
	        for (int kisi = 0; kisi < kisiSayisi; kisi++) {
	            System.out.println("Lutfen asagidaki konulari 1 (en az onemli) ile 10 (en onemli) arasinda puanlayin.");
	            for (int i = 0; i < konular.length; i++) {
	                System.out.print(konular[i]+":");
	                int puan = scanner.nextInt();
	                if (puan >= 1 && puan <= 10) {
	                    yanitlar[i][puan - 1]++;
	                } else {
	                    System.out.println("Gecersiz puan! Lutfen 1 ile 10 arasinda bir deger girin.");
	                    i--;
	                }
	            }
	        }
	        
	        double enYuksekPuan = 0;
	        String enYuksekKonu = "";
	        
	        double enDusukOrtalama = Double.MAX_VALUE;
	        String enDusukKonu = "";
	        
	        for (int i = 0; i < konular.length; i++) {
	            int toplam = 0;
	            int toplamOy = 0;
	            
	            for (int j = 0; j < 10; j++) {
	                toplam += yanitlar[i][j] * (j + 1);
	                toplamOy += yanitlar[i][j];
	            }
	            
	            double ortalama = toplamOy > 0 ? (double) toplam / toplamOy : 0;
	            
	            if (toplam > enYuksekPuan) {
	                enYuksekPuan = toplam;
	                enYuksekKonu = konular[i];
	            }
	            
	            if (ortalama < enDusukOrtalama) {
	                enDusukOrtalama = ortalama;
	                enDusukKonu = konular[i];
	            }

	            System.out.printf("%s ortalaması: %.2f\n", konular[i], ortalama);
	        }
	        
	        System.out.println("En yuksek puani alan : " + enYuksekKonu + " (" + enYuksekPuan + ")");
	        System.out.printf("En dusuk ortalama puani alan : %s (%.2f)\n", enDusukKonu , enDusukOrtalama);
	        
	        
	    }

}

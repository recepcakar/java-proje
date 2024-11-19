package hafta3;

public class salerpaper {
	int i=0;
	 double uruncaunt; 
	 double haftalik_maas=1500.0;
	 double komisyon=0.05;
	 double toplam_mas=1500.0;
	 salerpaper(int satilan)
	 {
		 this.uruncaunt=(double)satilan;
		 
		 while(i<uruncaunt)
		 {
			 toplam_mas+=haftalik_maas*komisyon;
			 i++;
		 }
	 }
	
 public void show() 
 {
	 System.out.println("maası:"+haftalik_maas);
	 System.out.println("komisyonu:"+(toplam_mas-haftalik_maas));
	 System.out.println("satılan ürün adedi :"+uruncaunt);
	
 }
 
}

package sinavornek;

public class test {

	public static void main(String[] args) {

 vehicle v1=new vehicle();
 v1.info();
 v1.gas();
 vehicle v2=new vehicle(43);
 v2.info(); 
  bike b1=new bike();
  b1.info();//üst sınıftan aldı
  b1.gas();//üst sınıfı override ettibq
  
	}

}

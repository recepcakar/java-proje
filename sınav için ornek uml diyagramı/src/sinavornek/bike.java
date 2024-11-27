package sinavornek;

public class bike  extends vehicle{
    bike(){
    	
    }
    protected void gas() {
    	System.out.println("üst sınıftaki methodu override ettik motor çalıştı oldu ");
    	
    	super.gas(); // üst sınıftaki methoda böyle erişebiliriz
    }
}

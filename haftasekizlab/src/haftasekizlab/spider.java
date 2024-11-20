package haftasekizlab;

public class spider extends animal

{
	protected int legs;
	spider(int legs){
		super(legs);
		this.legs=legs;
		
	}
 public void eat() {
	 System.out.println("ORUMCEK YEMEK YER");
	 
 }
 public void spider() {
	 System.out.println("hayvan = spider bacak sayuısı "+ this.legs);
 }
}

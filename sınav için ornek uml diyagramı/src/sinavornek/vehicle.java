package sinavornek;

public class vehicle {
private int wheels;
  vehicle()
  {
	
 }
vehicle(int whells){
	this.wheels=whells;
	
}

protected void gas() {
	System.out.println("araç çalıştı");
	
}

public void info() {
	System.out.println("araç bilgileri girilcek");
	if(wheels!=0)
		System.out.println("wheels : " + wheels);
}
}


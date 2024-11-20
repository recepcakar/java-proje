package haftasekizlab;

public class dogs extends animal implements pet  {
  String name;
	dogs(String name){
	
		this.name=name;
	}
	dogs(){}
	@Override
	public String getName(String name) {
		
		return this.name;
	}
	@Override
	public void setName() {

       this.name=name;
		
	}
	@Override
	 public void play() {
		System.out.println("kedi oynadı");
		
	}

	
	
	 public void eat() {
		 System.out.println("kedi YEMEK YER");
		 
	 }
	
	

	
	
}

package haftasekizlab;

public class fish extends animal implements pet {

	  String name;
		fish(String name){
		
			this.name=name;
		}
		fish(){}
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
			System.out.println("balık horon tepti");
			
		}

		
		
		 public void eat() {
			 System.out.println("balık YEMEK YER");
			 
		 }
		 public void valk() {
			 System.out.println("hamsi yürüyemedi");
		 }
		
		

	
 
}

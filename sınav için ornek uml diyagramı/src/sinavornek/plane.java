package sinavornek;

public class plane extends vehicle implements engine{
   
	float height;
	plane(){
		
	}
	
	protected void fly() {
		System.out.println("ucak uctu");
	}
	@Override
	public void speed() { //implements ettiğimiz interfacetaki methodları override ettik
		
		System.out.println("ucak hızı....");
	}

	@Override
	public bool isBroken() {
		 System.out.println("arızalı mı değil mi ");
		return null;
	}

}

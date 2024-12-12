package sinavornek;

public class boat  extends vehicle implements engine{
	public float travel;
protected float distance;

boat(){
	
}
float travel(int x) 
{ 
	this.travel=x;
	return travel;
}

public void info() {
	System.out.println("travel is : "+ travel);
	
	System.out.println("boat infodayız");
}
@Override
public void speed() {
	System.out.println("bot hızı");	
	
}
@Override
public bool isBroken() {
	System.out.println("arızalı mı değil mi");
	return null;
}
}

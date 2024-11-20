package haftasekizlab;

public class animal {
protected int legs;
String name;
animal(String name,int legs){
	this.name=name;
	this.legs=legs;
 }
animal(int legs){
	
	this.legs=legs;
 }
 animal (){
	
}

 public void valk() {
	System.out.println("hayvan yürüyor");
 }
 public void eat()  {
	System.out.println("hayvan yemek yer");
 }
}

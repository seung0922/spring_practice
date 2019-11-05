package org.zerock.sample;

public class Restaurant {
	
	private Chef chef;
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void cook() {
		System.out.println("요리를 한다....");
		chef.cook();
	}
	
}

package org.zerock.sample;

public class Restaurant {
	
	private Chef chef;
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void cook() {
		System.out.println("�丮�� �Ѵ�....");
		chef.cook();
	}
	
}

package org.zerock.dto;

public class Addr {

	private String zip, tel;

	@Override
	public String toString() {
		return "Addr [zip=" + zip + ", tel=" + tel + "]";
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}

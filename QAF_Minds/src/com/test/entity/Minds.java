package com.test.entity;



public class Minds {

	public String mid;
	public String mName;
	public String level;
	public double salary;
	
	public Minds() {
		new Minds();
	}
	
	public Minds(String mid, String mName, String level, int i) {
		this.mid =mid;
		this.mName = mName;
		this.level = level;
		this.salary = i;
	}
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}

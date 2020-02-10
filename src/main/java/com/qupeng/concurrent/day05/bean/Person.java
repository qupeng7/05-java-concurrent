package com.qupeng.concurrent.day05.bean;

/**
 * 用于实验的实体对象
 * @author qupeng
 */
public class Person{
	
	private int age;
	
	/*
	 * 细胞
	 */
	private long cells;
	
	private  String name;
	
	private String address;
	

	public Person(String name,int age,String address){
		this.name=name;
		this.age=age;
		this.address=address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public long getCells() {
		return cells;
	}

	public void setCells(long cells) {
		this.cells = cells;
	}

	@Override
	public String toString() {
		return "Person [name=" + name +",age=" + age +  ", address=" + address + ", cells=" + cells + "]";
	}
	
}

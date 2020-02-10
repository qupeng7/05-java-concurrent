package com.qupeng.concurrent.day05.bean;

/**
 * 用于实验的实体对象
 * @author qupeng
 */
public class PulbicPerson{
	
	public volatile int testNum;
	
	public volatile int  age;
	
	/*
	 * 细胞
	 */
	public volatile long cells;
	
	public volatile  String name;
	
	public volatile String address;
	

	public PulbicPerson(String name,int age,String address){
		this.name=name;
		this.age=age;
		this.address=address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name +",age=" + age +  ", address=" + address + ", cells=" + cells + "]";
	}
	
}

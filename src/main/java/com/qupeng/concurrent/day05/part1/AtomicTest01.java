package com.qupeng.concurrent.day05.part1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类AtomicInteger的API讲解
 * @author qupeng
 */
public class AtomicTest01 {

	public static void main(String[] args) {
		AtomicInteger atmInteger=new AtomicInteger();
		/*
		 * 注意下面的API都是线程不安全的，只用于初始化使用
		 * 在多线程共享数据时不要使用
		 */
		System.out.println("获取值："+atmInteger.get());
		atmInteger=new AtomicInteger(5);
		System.out.println("获取值："+atmInteger.get());
		atmInteger.set(10);
		System.out.println("获取值："+atmInteger.get());
		
		/*
		 * 以下方法能保证多线程情况下的原子性
		 */
//		int getAndAddResult = atmInteger.getAndAdd(10);//a=a+10
//		System.out.println("自增后的返回值："+getAndAddResult);
//		System.out.println("当前类中的值："+atmInteger.get());
		
		//没有提供自减指定值的方法所以用这样的方式实现自减
//		atmInteger.getAndAdd(-5);//a=a-5
//		atmInteger.decrementAndGet();//a--
		/*
		 * 原子赋值操作，必须传当前最新读到的预期值，
		 * 且必须为int类型
		 */
//		atmInteger.compareAndSet(10, 20);
//		atmInteger.compareAndSet(15, 20);
//		atmInteger.compareAndSet(10L, 20L);
		
		System.out.println("当前类中的值："+atmInteger);
		

	}

}

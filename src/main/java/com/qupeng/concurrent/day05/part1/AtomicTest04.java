package com.qupeng.concurrent.day05.part1;

import com.qupeng.concurrent.day05.bean.Person;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子类AtomicReference的API讲解
 * @author qupeng
 */
public class AtomicTest04 {

	public static void main(String[] args) {
		
		AtomicReference<Person> atmRef=new AtomicReference<>();
		/*
		 * 注意下面的API都是线程不安全的，只用于初始化使用
		 * 在多线程共享数据时不要在线程内部去使用
		 */
		Person p=new Person("qupeng",115,"北京");
		/*
		 * 对于没有重写hashCode的类的实例那么它的hashCode就是它的引用地址
		 * 这里用int数组为例，证明对象的引用是用一个int型的变量来存储的
		 */
		int[]  arr=new int[10];
		int refInt= arr.hashCode();
		System.out.println("数组对象的引用是："+arr);
		System.out.println("数组对象的引用，用int类型表示为："+refInt);
		atmRef.set(p);
		
		
		//要赋值的时候用这个API，可以保证本赋值操作的原子性
//		Person toUpdateP = new Person("Cat", 38, "北京");
//		atmRef.getAndSet(toUpdateP);
		/*
		 * 和AtomicInteger一样，必须传一个预期的值，如果预期的值
		 * 和当前类中的值不同（就是在赋值过程中有被其它线程打断更改的情况）
		 * 那么就不进行赋值操作，保留原值。
		 */
//		boolean casIsSuccess = atmRef.compareAndSet(new Person("Cat", 38, "杭州"), toUpdateP);
//		boolean casIsSuccess = atmRef.compareAndSet(p, toUpdateP);
		
//		System.out.println("CAS操作是否成功："+casIsSuccess);
		System.out.println("当前类中的值："+atmRef);
		
		
		
		/*
		 * 如果要实现原子写操作，那么自己手写一个原子类
		 * 我已经写好了，请看MyAtomicReference
		 */

	}

}




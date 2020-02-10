package com.qupeng.concurrent.day05.part1;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 原子类AtomicBoolean的API讲解
 * @author qupeng
 */
public class AtomicTest02 {

	public static void main(String[] args) {
		
		AtomicBoolean atmBoolean=new AtomicBoolean();
		/*
		 * 注意下面的API都是线程不安全的，只用于初始化使用
		 * 在多线程共享数据时不要使用
		 */
//		atmBoolean.set(true);
		
		
		//要赋值的时候用这个API，可以保证本赋值操作的原子性
//		atmBoolean.getAndSet(true);
		/*
		 * 和AtomicInteger一样，必须传一个预期的值，如果预期的值
		 * 和当前类中的值不同（就是在赋值过程中有被其它线程打断更改的情况）
		 * 那么就不进行赋值操作，保留原值。
		 */
		atmBoolean.compareAndSet(true, true);
		
		System.out.println("当前类中的值："+atmBoolean);
		

	}

}

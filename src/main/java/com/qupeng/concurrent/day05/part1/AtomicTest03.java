package com.qupeng.concurrent.day05.part1;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 原子类AtomicLong的API讲解
 * CPU有32位的，也有64位的，
 * 32位的CPU代表依次汇编指令一次可以处理32  bit（位）的数据
 * 64位的CPU代表依次汇编指令一次可以处理64  bit（位）的数据
 * 
 * int     是等于4byte（4个字节）=  32位
 * long  是等于8byte（8个字节）=64位
 * 如果是32位的CPU，那么处理long型的数据是先读高位，再读低位分两次读取
 * 为了保证2次读取的原子性，那么就在AtomicLong中加了一个对32位CPU的支持
 * @author qupeng
 */
public class AtomicTest03 {

	public static void main(String[] args) {
		
		AtomicLong atmLong=new AtomicLong();
		/*
		 * 注意下面的API都是线程不安全的，只用于初始化使用
		 * 在多线程共享数据时不要使用
		 */
		atmLong.set(30L);
		
		
		//要赋值的时候用这个API，可以保证本赋值操作的原子性
//		atmLong.getAndSet(35L);
		/*
		 * 和AtomicInteger一样，必须传一个预期的值，如果预期的值
		 * 和当前类中的值不同（就是在赋值过程中有被其它线程打断更改的情况）
		 * 那么就不进行赋值操作，保留原值。
		 */
//		atmLong.compareAndSet(31L, 35L);
//		atmLong.compareAndSet(30L, 35L);
		
		System.out.println("当前类中的值："+atmLong);

	}

}

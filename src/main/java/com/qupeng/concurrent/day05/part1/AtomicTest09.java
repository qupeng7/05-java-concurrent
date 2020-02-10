package com.qupeng.concurrent.day05.part1;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * 原子类AtomicIntegerArray、AtomicLongArray和
 * AtomicReferenceArray的API讲解
 * 
 * @author qupeng
 */
public class AtomicTest09 {

	public static void main(String[] args) {
		
//		AtomicIntegerArray  atmIntArr=new AtomicIntegerArray(5);
		AtomicIntegerArray  atmIntArr=new AtomicIntegerArray(new int[]{1,2,3,4,5});
		AtomicLongArray   atmLongArr=new AtomicLongArray(6);
		AtomicReferenceArray<String>   atmRefArr=new AtomicReferenceArray<>(7);
//		atmIntArr.set(0, 11);
//		atmIntArr.getAndSet(0, 12);
		/*
		 * 传入一个期望值，如果当前读到的值和预期值一样就更新
		 * 不一样就什么也不做
		 */
		boolean casIsSuccess = atmIntArr.compareAndSet(1, 2, 12);
//		boolean casIsSuccess = atmIntArr.compareAndSet(1, 22, 12);
		
		//-------------AtomicIntegerArray的打印
		System.out.println("整型数组长度为："+atmIntArr.length());
		System.out.println("整型数组第1个元素为："+atmIntArr.get(0));
		System.out.println("整型数组第2个元素为："+atmIntArr.get(1));
		
		//-------------AtomicLongArray的打印
		atmLongArr.getAndSet(5, 6);
		System.out.println("长整型数组长度为："+atmLongArr.length());
		System.out.println("长整型第1个元素为："+atmLongArr.get(0));
		System.out.println("长整型第6个元素为："+atmLongArr.get(5));
		
		
		//-------------AtomicReferenceArray的打印
		atmRefArr.getAndSet(6, "qupeng");
		System.out.println("引用类型数组长度为："+atmRefArr.length());
		System.out.println("引用类型第1个元素为："+atmRefArr.get(0));
		System.out.println("引用类型第7个元素为："+atmRefArr.get(6));

		System.out.println("CAS操作是否成功："+casIsSuccess);
//		System.out.println("当前类中的值：" + atmMarRef.getReference());

	}

}

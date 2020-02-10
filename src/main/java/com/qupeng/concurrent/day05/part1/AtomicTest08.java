package com.qupeng.concurrent.day05.part1;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * 解决ABA问题 原子类AtomicMarkableReference的API讲解
 * 
 * @author qupeng
 */
public class AtomicTest08 {

	public static void main(String[] args) {
		AtomicMarkableReference<Integer>  atmMarRef=new AtomicMarkableReference<Integer>(50, false);
		boolean marked = atmMarRef.isMarked();
		boolean casIsSuccess = atmMarRef.compareAndSet(50, 51, marked, !marked);
//		boolean casIsSuccess = atmMarRef.compareAndSet(50, 51, true, !marked);

		System.out.println("CAS操作是否成功："+casIsSuccess);
		System.out.println("当前类中的值：" + atmMarRef.getReference());

	}

}

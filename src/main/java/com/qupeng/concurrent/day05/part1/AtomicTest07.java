package com.qupeng.concurrent.day05.part1;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 解决ABA问题 原子类AtomicStampedReference的API讲解
 * 
 * @author qupeng
 */
public class AtomicTest07 {

	public static void main(String[] args) {
		AtomicStampedReference<Integer> atmStaRef = new AtomicStampedReference<Integer>(40, 0);
		int stamp = atmStaRef.getStamp();
		boolean casIsSuccess = atmStaRef.compareAndSet(40, 41, stamp, stamp + 1);
//		boolean casIsSuccess =atmStaRef.compareAndSet(40, 41,1 , stamp+1);

		System.out.println("CAS操作是否成功："+casIsSuccess);
		System.out.println("当前类中的值：" + atmStaRef.getReference());

	}

}

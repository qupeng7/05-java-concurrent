package com.qupeng.concurrent.day05.part1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.LockSupport;


/**
 * 解决ABA问题
 * @author qupeng
 */
public class AtomicTest06_1 {

	public static void main(String[] args) {
		
		final AtomicStampedReference<Integer>    atmStaRef=new AtomicStampedReference<Integer>(1, 0);
		
		new Thread("线程1："){
			
			@Override
			public void run() {
				String threadName = Thread.currentThread().getName();
				//这里读到的是1
				int getValue = atmStaRef.getReference();
				int stamp = atmStaRef.getStamp();
				System.out.println(threadName+"读到的数据是："+getValue+"，版本号是："+stamp);
				//在进行CAS算法的原子操作之前阻塞1秒方便其它线程进行打断后操作
				LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
				if(atmStaRef.compareAndSet(getValue, 2, stamp, stamp+1)){
					System.out.println(threadName+"把："+getValue+"更新为   5成功！");
				}else{
					System.out.println(threadName+"更新操作失败！");
				}
			}
			
		}.start();
		
		
		new Thread("线程2："){
			
			@Override
			public void run() {
				String threadName = Thread.currentThread().getName();
				//这里读到的是1
				int getValue = atmStaRef.getReference();
				int stamp = atmStaRef.getStamp();
				System.out.println(threadName+"读到的数据是："+getValue);
				//进行CAS算法的原子操作将1  ---->2
				if(atmStaRef.compareAndSet(getValue, 2,stamp,stamp+1)){
					System.out.println(threadName+"把："+getValue+"更新为   2");
					getValue= atmStaRef.getReference();
					System.out.println(threadName+"读到的数据是："+getValue);
					//进行CAS算法的原子操作将2  ---->1
					if(atmStaRef.compareAndSet(getValue, 1,stamp,stamp+1)){
						System.out.println(threadName+"把："+getValue+"更新为   1成功！");
					}
				}
			}
			
		}.start();
		
	}

}
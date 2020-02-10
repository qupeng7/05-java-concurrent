package com.qupeng.concurrent.day05.part1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.locks.LockSupport;


/**
 * 解决ABA问题
 * @author qupeng
 */
public class AtomicTest06_2 {

	public static void main(String[] args) {
		
		final AtomicMarkableReference<Integer>  atmMarRef=new AtomicMarkableReference<Integer>(1, false);
		new Thread("线程1："){
			
			@Override
			public void run() {
				String threadName = Thread.currentThread().getName();
				//这里读到的是1
				int getValue = atmMarRef.getReference();
				boolean marked = atmMarRef.isMarked();
				System.out.println(threadName+"读到的数据是："+getValue+"，标记是："+marked);
				//在进行CAS算法的原子操作之前阻塞1秒方便其它线程进行打断后操作
				LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
				if(atmMarRef.compareAndSet(getValue, 2, marked, true)){
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
				int getValue = atmMarRef.getReference();
				boolean marked = atmMarRef.isMarked();
				System.out.println(threadName+"读到的数据是："+getValue+"，标记是："+marked);
				//进行CAS算法的原子操作将1  ---->2
				if(atmMarRef.compareAndSet(getValue, 2,marked,!marked)&&atmMarRef.attemptMark(2, marked)){
					System.out.println(threadName+"把："+getValue+"更新为   2");
					//重置marked
					
					
					getValue= atmMarRef.getReference();
					marked=atmMarRef.isMarked();
					System.out.println(threadName+"读到的数据是："+getValue);
					//进行CAS算法的原子操作将2  ---->1
					if(atmMarRef.compareAndSet(getValue, 1,marked,!marked)){
						System.out.println(threadName+"把："+getValue+"更新为   1成功！");
					}
				}
			}
			
		}.start();
		
	}

}
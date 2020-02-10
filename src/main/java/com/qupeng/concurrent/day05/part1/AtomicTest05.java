package com.qupeng.concurrent.day05.part1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * ABA问题
 * @author qupeng
 */
public class AtomicTest05 {
	

	public static void main(String[] args) {
		final AtomicInteger atmInteger=new AtomicInteger(1);
		
		
		new Thread("线程1："){
			
			@Override
			public void run() {
				String threadName = Thread.currentThread().getName();
				//这里读到的是1
				int getValue = atmInteger.get();
				System.out.println(threadName+"读到的数据是："+getValue);
				//在进行CAS算法的原子操作之前阻塞1秒方便其它线程进行打断后操作
				LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
				//进行CAS算法的原子操作将1  ---->2
				if(atmInteger.compareAndSet(getValue, 5)){
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
				int getValue = atmInteger.get();
				System.out.println(threadName+"读到的数据是："+getValue);
				//进行CAS算法的原子操作将1  ---->2
				if(atmInteger.compareAndSet(getValue, 2)){
					System.out.println(threadName+"把："+getValue+"更新为   2");
					getValue= atmInteger.get();
					System.out.println(threadName+"读到的数据是："+getValue);
					//进行CAS算法的原子操作将2  ---->1
					if(atmInteger.compareAndSet(getValue, 1)){
						System.out.println(threadName+"把："+getValue+"更新为   1成功！");
					}
				}
			}
			
		}.start();
		
	}

}

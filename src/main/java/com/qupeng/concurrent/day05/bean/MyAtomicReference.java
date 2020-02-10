package com.qupeng.concurrent.day05.bean;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;


/**
 * 自己手写一个原子的引用类
 * @author qupeng
 */
public class MyAtomicReference<Va>{
	
	private AtomicReference<Va> atmRef = null;

	public MyAtomicReference(Va initialRef) {
		atmRef = new AtomicReference<Va>(initialRef);
	}
	
	public Va  get(){
		return atmRef.get();
	}
	
	/**
	 * 这个原子性的功能的定义是保证当前更新操作的原子性
	 * @param newReference
	 */
	public void getAndUpdate(Va newReference) {
		String threadName = Thread.currentThread().getName();
		while (true) {
			//读取到最新的引用
			Va currentReference = atmRef.get();
			if("线程1：".equals(threadName)){
				System.out.println(threadName+"准备把："+currentReference+"   改为："+newReference+"后进入休眠中……");
				LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(300));
			}
			if (atmRef.compareAndSet(currentReference, newReference)){
				System.out.println(threadName+"已经把："+currentReference+"    改为了："+newReference);
				return;
			}
		}
	}
}


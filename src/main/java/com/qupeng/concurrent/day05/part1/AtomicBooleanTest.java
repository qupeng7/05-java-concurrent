package com.qupeng.concurrent.day05.part1;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 使用AtomicBoolean保证多线程间的可见性
 * @author qupeng
 */
public class AtomicBooleanTest {

	static class Test {

//		public  volatile  boolean  b = true;
		
		public   AtomicBoolean  b = new AtomicBoolean(true);
		
		public void testMethod() {
			String threadNme = Thread.currentThread().getName();
			System.out.println(threadNme + "：开始执行testMethod方法……");
			while (b.get()) {
				int a = 1;
				a++;
				a=0;
			}
			System.out.println(threadNme + "：执行testMethod方法结束！");
		}

	}

	public static void main(String[] args) throws InterruptedException {
		
		final Test t=new Test();
		
		new Thread("线程1"){
			
			@Override
			public void run() {
				t.testMethod();
			}
		}.start();

		// 休息1秒
		Thread.sleep(1_000);
		t.b.set(false);
//		t.b.compareAndSet(true, false);
		System.out.println(Thread.currentThread().getName() + "：此时的b的值是：" + t.b);

	}

}

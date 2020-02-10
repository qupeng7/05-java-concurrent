package com.qupeng.concurrent.day05.part1;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.atomic.AtomicStampedReference;


/**
 * 原子类AtomicIntegerFieldUpdater、
 * AtomicLongFieldUpdater和AtomicReferenceFieldUpdater
 * 的使用场景：
 * 
 * 如果一个类中有某个成员变量需要在写操作的时候具备原子性
 * 又不想加锁，还要考虑节约内存，那么就用AtomicXXXFieldUpdater
 * @author qupeng
 */
public class AtomicTest11 {

	public static void main(String[] args) {
		//这里的话就要使用16个字节进行存储
		Node node = new Node();
		//这里又需要16个字节进行存储，那么总共最少需要32个自己进行存储
		AtomicStampedReference<Node> atmStpRef =
				new AtomicStampedReference<>(node, 0);
		
		//而用AtomicReferenceFieldUpdater只需要多加4个字节
		AtomicReferenceFieldUpdater<Node,Node> atmRefFdUpd=
				AtomicReferenceFieldUpdater.newUpdater(Node.class, Node.class, "pre");
	}
	
	
	//总共16个字节
	static  class Node{//4个字节
		
		private  volatile  Node pre;//4个字节

		private  volatile  Node next;//4个字节
		
		private  volatile  Object value;//4个字节
		
	}

}

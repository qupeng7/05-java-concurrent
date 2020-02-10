package com.qupeng.concurrent.day05.part1;

import com.qupeng.concurrent.day05.bean.PulbicPerson;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * 原子类AtomicIntegerFieldUpdater、
 * AtomicLongFieldUpdater和AtomicReferenceFieldUpdater的API讲解
 * 
 * 注意事项：
 * 1、类中的属性必须是访问权限许可的
 * 2、类中的属性必须是用volatile修饰的
 * 3、传入对象必须不为null
 * @author qupeng
 */
public class AtomicTest10 {

	public static void main(String[] args) {
		
		AtomicIntegerFieldUpdater<PulbicPerson> atmIntFdUpd=AtomicIntegerFieldUpdater.newUpdater(PulbicPerson.class, "age");
		AtomicLongFieldUpdater<PulbicPerson> atmLoUpd=AtomicLongFieldUpdater.newUpdater(PulbicPerson.class, "age");
		AtomicReferenceFieldUpdater<PulbicPerson, String> atmRefUpd=AtomicReferenceFieldUpdater.newUpdater(PulbicPerson.class, String.class, "name");
		
		PulbicPerson pp=new PulbicPerson("qupeng", 115, "蓬莱仙岛");
		atmIntFdUpd.getAndIncrement(pp);
		
//		atmLoUpd.getAndIncrement(pp);
		
		//传的属性名找不到
		
		
		//传一个null过去
//		atmRefUpd.getAndSet(null, "Cat");
		
		//去除泛型后，传一个非法类的对象过去
//		atmRefUpd.getAndSet(new Person("", 0, ""), "大雷音寺");
		
		
		
//		System.out.println("CAS操作是否成功："+casIsSuccess);
		System.out.println("当前类中的值：" + atmIntFdUpd.get(pp));
		System.out.println("当前类中的值：" + atmLoUpd.get(pp));
		System.out.println("当前类中的值：" + atmRefUpd.get(pp));

	}

}

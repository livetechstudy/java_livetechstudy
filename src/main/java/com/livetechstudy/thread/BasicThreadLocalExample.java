package com.livetechstudy.thread;

import java.util.function.Supplier;

public class BasicThreadLocalExample {
	public static void main(String[] args) {
		ThreadLocal<Integer>tl1 = new ThreadLocal<>();
		//System.out.println(tl1.get());
		//tl1.set(100);
		//System.out.println(tl1.get());
		
		ThreadLocal<Integer>tl2 = ThreadLocal.withInitial(new Supplier<Integer>() {

			@Override
			public Integer get() {
				return 200;
			}
		});
		
		//System.out.println(tl2.get());
		
		ThreadLocal<Integer>tl3 = ThreadLocal.withInitial(()->300);
		//System.out.println(tl3.get());
		
		ThreadLocal<Integer>tl4 = new ThreadLocal<Integer>() {

			@Override
			protected Integer initialValue() {
				return 400;
			}
			
		};
		System.out.println(tl4.get());
	}

}

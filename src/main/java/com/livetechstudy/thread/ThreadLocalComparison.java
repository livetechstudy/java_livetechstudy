package com.livetechstudy.thread;

public class ThreadLocalComparison {
	public static void main(String[] args) throws InterruptedException {
		// Runnable runnable = new SimpleRunnable();

		Runnable runnable = new ThreadLocalRunnable();
		Thread t1 = new Thread(runnable, "First Thread");
		Thread t2 = new Thread(runnable, "Second Thread");

		t1.start();
		t1.join();
		t2.start();
		t2.join();
	}
}

class ThreadLocalRunnable implements Runnable {
	private ThreadLocal<Counter> counter = ThreadLocal.withInitial(() -> new Counter());

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			counter.get().increment();
		}
		System.out.println(Thread.currentThread().getName() + " Count=" + counter.get().getCount());
	}

}

class SimpleRunnable implements Runnable {
	private Counter counter = new Counter();

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			counter.increment();
		}
		System.out.println(Thread.currentThread().getName() + " Count=" + counter.getCount());
	}

}

class Counter {
	private int count = 0;

	public void increment() {
		count++;
	}

	public int getCount() {
		return count;
	}

}
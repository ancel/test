package com.ancel.test.collection;

import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.offer(34);
		pq.offer(12);
		pq.offer(24);
		pq.offer(-4);
		pq.offer(36);
		System.out.println(pq);
		System.out.println(pq.peek());
	}
}

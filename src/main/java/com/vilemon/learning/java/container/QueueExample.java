package com.vilemon.learning.java.container;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

/**
 * Java结合框架中主要封装的是经典的数据结构和算法，如动态数组、双向链表、栈、队列、集合、哈希表等
 * Java集合可以分为两大体系: Collection和Map
 * Collection: List、Set、Queue接口都是Collection的子接口
 * Queue: Queue模拟队列这种数据结构，队列是先进先出(FIFO)的容器
 * Queue主要实现类：PriorityQueue、ArrayDeque、LinkedList(实现了Deque接口和List接口，这里不详细阐述)
 */
public class QueueExample {
    /**
     * 队列的顺序并不是按照元素加入队列的顺序，而是按照队列的大小进行重新排序
     * PriorityQueue的元素有两种排序方式：自然排序和定制排序
     */
    public void demoPriorityQueue() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(6);
        queue.offer(9);
        queue.offer(-1);
        queue.offer(5);
        queue.offer(-3);
        // 输出[-3, -1, 6, 9, 5]
        System.out.println(queue);
    }

    /**
     * ArrayDeque实现了Deque接口，Deque接口是Queue的子接口
     * Deque接口实现了一个双端队列，允许从两端来操作队列的元素
     * ArrayDeque是一个基于数组实现的双端队列
     * ArrayDeque既可以用于实现队列，也可以用于实现栈
     */
    public void demoArrayDeque() {
        // 作为栈使用
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push("语文");
        stack.push("数学");
        stack.push("英语");
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);

        // 作为队列使用
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.offer("语文");
        queue.offer("数学");
        queue.offer("英语");
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}

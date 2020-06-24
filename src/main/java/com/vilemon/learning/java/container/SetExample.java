package com.vilemon.learning.java.container;

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Java结合框架中主要封装的是经典的数据结构和算法，如动态数组、双向链表、栈、队列、集合、哈希表等
 * Java集合可以分为两大体系: Collection和Map
 * Collection: List、Set、Queue接口都是Collection的子接口
 * Set: Set集合是无序且不可重复的
 * Set主要实现类：HashSet、LinkedHashSet、TreeSet
 */
public class SetExample {
    /**
     * HashSet是Set接口的典型实现，大多数时候使用Set集合就是使用这个实现类
     * HashSet按Hash算法来存储集合中的元素，因此具有很好的存取和查找性能
     * 当向HashSet集合中存入一个元素时，HashSet会调用该对象的hashCode()方法来得到该对象的hashCode值，
     * 然后根据hashCode值决定该对象在HashSet中的存储位置
     */
    public void demoHashSet() {
        Set<String> courses = new HashSet<>();
        courses.add("语文");
        courses.add("数学");
        courses.add("英语");
        courses.add("数学");
        courses.add("英语");
        System.out.println(courses);
    }

    /**
     * LinkedHashSet是HashSet的子类
     * LinkedHashSet集合也是根据hashCode值来决定元素的存储位置，但同时使用链表维护元素的次序
     */
    public void demoLinkedHashSet() {
        Set<String> courses = new LinkedHashSet<>();
        courses.add("语文");
        courses.add("数学");
        courses.add("外语");
        System.out.println(courses);
    }

    /**
     * TreeSet是SortedSet接口的实现类，可以确保集合元素处于排序状态
     */
    public void demoTreeSet() {
        TreeSet<Integer> nums = new TreeSet<>();
        nums.add(6);
        nums.add(8);
        nums.add(1);
        nums.add(5);
        nums.add(3);
        nums.add(7);
        // 输出集合元素，集合元素已处于排序状态
        System.out.println(nums);
    }
}

package com.vilemon.learning.java.container;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.Stack;
import java.util.LinkedList;

/**
 * Java结合框架中主要封装的是经典的数据结构和算法，如动态数组、双向链表、栈、队列、集合、哈希表等
 * Java集合可以分为两大体系: Collection和Map
 * Collection: List、Set、Queue接口都是Collection的子接口
 * List: List集合的特点就是存取有序，可以存储重复的元素，可以使用下标操作元素
 * List主要实现类：ArrayList、Vector、Stack、LinkedList
 */
public class ListExample {
    /**
     * ArrayList是一个动态数组结构，支持随机存取，尾部插入删除效率高，内部插入删除效率低（因为要移动数组元素）
     * 实例化时可以指定内部数组的容量，如果没有指定默认初始容量为10
     * 当添加的元素个数超过数组的长度时，ArrayList会进行自动扩容
     * ArrayList是线程不安全的，当多个线程同时访问一个ArrayList集合时，程序需要保证该集合的同步性
     */
    public void demoArrayList() {
        List<String> course = new ArrayList<>();
        List<String> course1 = new ArrayList<>();
        List<String> course2 = new ArrayList<>();
        // add() 向容器中添加元素
        course.add("语文");
        course.add("数学");
        course.add("英语");
        course1.add("物理");
        course1.add("化学");
        course1.add("生物");
        course2.add("历史");
        course2.add("政治");
        course2.add("地理");
        // addAll() 向容器中添加一个集合
        course.addAll(course1);
        course.addAll(course2);
        // iterator() 返回一个迭代器，通过迭代器遍历
        Iterator it = course.iterator();
        while (it.hasNext()) {
            Object obj = it.next();
            // indexOf() 返回对象在集合中第一次出现的位置索引
            int firstIndex = course.indexOf(obj);
            // lastIndexOf() 返回对象在集合中最后一次出现的位置索引
            int lastIndex = course.lastIndexOf(obj);
            System.out.printf("%s-%d-%d\n", obj, firstIndex, lastIndex);
        }
        // get() 返回集合中对应索引的元素
        String subject = course.get(5);
        System.out.println(subject);
        // set() 设置索引对应的元素
        course.set(5, "地理");
        System.out.println(course);
        // remove 删除对应的元素
        course.remove(5);
        System.out.println(course);
        //subCourse() 返回子集合
        List<String> subCourse = course.subList(2, 5);
        System.out.println(subCourse);
    }

    /**
     * Vector也是一个动态数组结构，是一个比较古老的类，目前不推荐使用
     * 大部分方法和ArrayList相同，不同的是Vector集合是线程安全的，无需程序保证集合的同步性
     * 因为是线程安全的，所以效率相较ArrayList要低
     */
    public void demoVector() {
        List<String> vList = new Vector<>();
        vList.add("语文");
        vList.add("数学");
        vList.add("英语");
        // for循环遍历
        for (String subject : vList) {
            System.out.println(subject);
        }
    }

    /**
     * Stack是Vector的一个子类，本质上也是一个动态数组结构，用于模拟栈这种数据结构
     * 由于继承Vector，所以也是线程安全的，性能较差
     */
    public void demoStack() {
        Stack<String> stack = new Stack<>();
        stack.add("语文");
        stack.add("数学");
        stack.add("英语");
        System.out.println(stack);
        // push() 入栈
        stack.push("物理");
        stack.push("化学");
        stack.push("生物");
        System.out.println(stack);
        // pop() 出栈
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);
    }

    /**
     * LinkedList底层是一个双向链表结构
     * LinkedList是List接口的实现类，可以根据索引随机访问集合中的元素
     * LinkedList还实现了Deque接口，可以被当成双端队列来使用（栈和队列）
     *
     * LinkedList与ArrayList的实现机制完全不同
     * ArrayList以数组的形式来保存集合中的元素，随机访问集合元素时有较好的性能
     * LinkedList以链表的形式来保存集合中的元素，随机访问集合元素性能较差，插入/删除元素性能较好
     * 插入/删除元素时只需要改变指针所指的地址即可
     */
    public void demoLinkedList() {
        LinkedList<String> lList = new LinkedList<>();
        lList.add("语文");
        lList.add("数学");
        lList.add("英语");
        System.out.println(lList);
        System.out.println(lList.get(1));
        // 将字符串元素加入到队列的尾部
        lList.offerLast("物理");
        // 将字符串元素加入到队列的头部（相当于栈顶）
        lList.offerFirst("化学");
        System.out.println(lList);
        // 按照索引访问方式遍历集合元素
        for (int i = 0; i < lList.size(); i++) {
            System.out.println("遍历中：" + lList.get(i));
        }
        // 访问并不删除元素
        System.out.println(lList.peekFirst());
        System.out.println(lList.peekLast());
        System.out.println(lList);
        // 访问并删除元素
        System.out.println(lList.pollFirst());
        System.out.println(lList.pollLast());
        System.out.println(lList);
    }
}

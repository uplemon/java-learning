package com.vilemon.learning.java.container;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.TreeMap;

/**
 * Java结合框架中主要封装的是经典的数据结构和算法，如动态数组、双向链表、栈、队列、集合、哈希表等
 * Java集合可以分为两大体系: Collection和Map
 * Map用于保存具有映射关系的数据，key和value之间存在单向一对一关系
 * Map主要实现类：HashMap、LinkedHashMap、Hashtable、Properties、TreeMap
 */
public class MapExample {
    /**
     * HashMap和Hashtable都是Map接口的典型实现类，它们之间的关系类似于ArrayList和Vector之间的关系
     * HashMap和Hashtable存在两点典型区别
     * 1. Hashtable是一个线程安全的Map实现，HashMap是一个线程不安全的Map实现
     * 2. Hashtable不允许使用null作为key和value，但HashMap可以使用null作为key或value
     */
    public void demoHashMap() {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("语文", 95);
        scores.put("数学", 98);
        scores.put("英语", 96);
        System.out.println(scores);
        // 判断是否包含指定key
        System.out.println(scores.containsKey("语文"));
        // 判断是否包含指定value
        System.out.println(scores.containsValue(96));
        // 获取所有key
        Set<String> keySet = scores.keySet();
        for (String key : keySet) {
            // 获取指定key对应的value
            System.out.println(key + ": " + scores.get(key));
        }
    }

    /**
     * 不推荐使用Hashtable类，即使需要线程安全的Map实现类，也无需使用Hashtable实现类
     * 可通过Collections工具类把HashMap变成线程安全的
     */
    public void demoHashtable() {
        Hashtable<String, Integer> scores = new Hashtable<>();
        try {
            scores.put("语文", 95);
            scores.put(null, 98);
            scores.put("英语", null);
        } catch (NullPointerException e) {
            System.out.println(scores);
            scores.put("数学", 98);
            scores.put("英语", 96);
        } catch (Exception e) {
            System.out.println("未知异常");
        }
        System.out.println(scores);
    }

    /**
     * LinkedHashMap是HashMap的子类
     * LinkedHashMap使用双向链表来维护key-value对的顺序，迭代顺序与插入顺序保持一致
     */
    public void demoLinkedHashMap() {
        LinkedHashMap<String, Integer> scores = new LinkedHashMap<>();
        scores.put("语文", 95);
        scores.put("数学", 98);
        scores.put("英语", 96);
        // 输出 {语文=95, 数学=98, 英语=96}
        System.out.println(scores);
        // java8为Map新增的forEach()方法来遍历Map集合
        scores.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    /**
     * Properties类是Hashtable类的子类
     * Properties类可以把Map对象和属性文件关联起来
     * 可以把Map对象中的key-value写入属性文件
     * 也可以把属性文件中的"属性名=属性值"加载到Map对象中
     * Properties的key和value都是字符串类型
     */
    public void demoProperties() {
        try {
            Properties props = new Properties();
            // 添加属性
            props.setProperty("host", "127.0.0.1");
            props.setProperty("port", "8080");
            // 保存文件
            FileOutputStream file1 = new FileOutputStream("/tmp/props.ini");
            props.store(file1, "comment line");

            // 新建一个Properties对象
            Properties newProps = new Properties();
            FileInputStream file2 = new FileInputStream("/tmp/props.ini");
            newProps.load(file2);
            System.out.println(newProps);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    /**
     * TreeMap是SortedMap的实现类
     * TreeMap是一个红黑树数据结构，每个key-value对作为红黑树的一个节点
     * TreeMap存储key-value对时需要根据key对节点进行排序
     * TreeMap可以保证所有key-value对处于有序状态
     * TreeMap有两种排序方式，自然排序和定制排序
     */
    public void demoTreeMap() {
        TreeMap<Integer, String> scores = new TreeMap<>();
        scores.put(95, "语文");
        scores.put(98, "数学");
        scores.put(96, "英语");
        // 输出 {95=语文, 96=英语, 98=数学}
        System.out.println(scores);
    }
}

package com.dxy.basic.reference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 软引用是用来描述一些还有用但并非必需的对象。
 * 对于软引用关联着的对象，在系统将要发生内存溢出异常之前，
 * 将会把这些对象列进回收范围之中进行第二次回收。
 * 如果这次回收还没有足够的内存，才会抛出oom
 */
public class SoftReferenceTest {
    ExecutorService executor = Executors.newCachedThreadPool();
    public void test() {
        SoftReference<byte[]> car = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(car.get());
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(car.get());
        byte[] b = new byte[1024 * 1024 * 15];
        System.out.println(car.get());
    }

    static class HeapObject {
        byte[] bs = new byte[1024 * 1024];
    }

    /**
     * 若干list add操作后内存不足 会回收软引用的对象
     *
     * @param args
     */
    public static void main(String[] args) {
        SoftReference<HeapObject> softReference = new SoftReference<>(new HeapObject());
        List<HeapObject> list = new ArrayList<>();

        while (true) {
            if (softReference.get() != null) {
                list.add(new HeapObject());
                System.out.println("list.add");
            } else {
                System.out.println("---------软引用已被回收---------");
                System.out.println(softReference == null);
                break;
            }
            System.gc();
        }
    }
}

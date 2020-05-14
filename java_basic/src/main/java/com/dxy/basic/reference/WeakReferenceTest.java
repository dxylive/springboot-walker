package com.dxy.basic.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用
 */
public class WeakReferenceTest {
    private static class TestObject {

    }

    public static void main(String[] args){
        ReferenceQueue<TestObject> queue = new ReferenceQueue<>();
        PhantomReference<TestObject> phantomReference = new PhantomReference<>(new TestObject(), queue);

        System.out.println(phantomReference.get() == null);//true

    }
}

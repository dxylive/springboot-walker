package com.dxy.basic.reference;

import com.dxy.basic.domain.Car;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 强引用(在对象为空的时候才会触发gc)
 */
public class StrongReferenceTest {
    public void test() throws IOException {
        Car car = new Car();
        car = null;
        System.gc();
        int read = System.in.read();
    }

    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(car == null);
    }
}

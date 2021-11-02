package com.hayaku.TestUtil;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimeUtil {
    public static long methodTime(Method method, Object obj, Object... args) {
        long t1 = 1, t2 = 0;
        try {
            t1 = System.currentTimeMillis();
            method.invoke(obj, args);
            t2 = System.currentTimeMillis();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return t2 - t1;
    }
    public static long methodAverageTime(int times, Method method, Object obj, Object... args) {
        long total = 0;
        int argsNum = args.length;
        Object[] clonedArgs = new Object[argsNum];
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < argsNum; j++) {
                if (args[j] instanceof Object[]) {
                    clonedArgs[j] = ((Object[]) args[j]).clone();
                } else {
                    try {
                        clonedArgs[j] = args[j].getClass().getDeclaredMethod("clone").invoke(args[j]);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }
            total += methodTime(method, obj, clonedArgs);
        }
        return total / times;
    }
}

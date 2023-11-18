package com.bscoder.annotation.chapter3;


import com.bscoder.annotation.common.Logging;

import java.lang.reflect.Method;

public class IsAnnotationPresentTest {

    @Logging
    public interface ParentService {
        @Logging
        void sayHello(String name);

    }

    public class ChildServiceImpl implements ParentService {

        @Override
        public void sayHello(String name) {
            System.out.println("hello," + name);
        }
    }

    @Logging
    public abstract class AbsService {

        @Logging
        public abstract void sayHello(String name);

    }

    @Logging
    public class ImplService extends AbsService {

        @Override
        public void sayHello(String name) {

        }
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        System.out.println(ParentService.class.isAnnotationPresent(Logging.class));
        System.out.println(ChildServiceImpl.class.isAnnotationPresent(Logging.class));

        //从父接口获取方法
        Method parentServiceMethod = ParentService.class.getMethod("sayHello", String.class);
        System.out.println(parentServiceMethod.isAnnotationPresent(Logging.class));

        //从子类实现获取方法
        Method childServiceMethod = ChildServiceImpl.class.getMethod("sayHello", String.class);
        System.out.println(childServiceMethod.isAnnotationPresent(Logging.class));

        //从抽象父类类获取方法
        Method absServiceMethod = AbsService.class.getMethod("sayHello", String.class);
        System.out.println(absServiceMethod.isAnnotationPresent(Logging.class));

        //从子类获取方法
        Method implServiceMethod = ImplService.class.getMethod("sayHello", String.class);
        System.out.println(implServiceMethod.isAnnotationPresent(Logging.class));
    }

}

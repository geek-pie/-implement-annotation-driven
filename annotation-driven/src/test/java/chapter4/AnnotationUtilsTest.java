package chapter4;

import com.bscoder.annotation.chapter4.AnnotationUtils;
import com.bscoder.annotation.common.Logging;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author xujianxing@sensetime.com
 * @date 2023年05月09日 15:41
 */
public class AnnotationUtilsTest {
    @Logging(id = "IParent")
    interface IParent {
        @Logging(id = "IParent.sayHello")
        void sayHello(String name);
    }

    @Logging(id = "Parent")
    class Parent {
        @Logging(id = "Parent.sayHello")
        public void sayHello(String name) {
            System.out.println(name);
        }
    }

    @Test
    public void testClass() {
        class Child extends Parent {
        }
        class Grandson extends Child {
        }

        class ChildImpl implements IParent {
            @Override
            public void sayHello(String name) {
            }
        }
        class GrandsonImpl extends Child implements IParent {
        }
        System.out.println(AnnotationUtils.findAnnotation(Child.class, Logging.class)[0].id());
        System.out.println(AnnotationUtils.findAnnotation(Grandson.class, Logging.class)[0].id());
        System.out.println(AnnotationUtils.findAnnotation(ChildImpl.class, Logging.class)[0].id());
        System.out.println(AnnotationUtils.findAnnotation(GrandsonImpl.class, Logging.class)[0].id());
    }

    @Test
    public void testMethodForSampleCase() throws NoSuchMethodException {
        class Child extends Parent {
            @Override
            public void sayHello(String name) {
                super.sayHello(name);
            }
        }
        class Grandson extends Child {
            @Override
            public void sayHello(String name) {
                super.sayHello(name);
            }
        }
        Method method = Child.class.getMethod("sayHello", String.class);
        System.out.println(AnnotationUtils.findAnnotation(method, Logging.class)[0].id());
        method = Grandson.class.getMethod("sayHello", String.class);
        System.out.println(AnnotationUtils.findAnnotation(method, Logging.class)[0].id());
    }

    @Logging(id = "GenericParent")
    interface GenericParent<T> {
        @Logging(id = "GenericParent.sayHello")
        void sayHello(T name);
    }


    @Test
    public void testMethodForGenericCase() throws NoSuchMethodException {
        class Child implements GenericParent<String> {
            @Override
            public void sayHello(String name) {
            }
        }
        Method method = Child.class.getMethod("sayHello", String.class);
        Logging[] annos = AnnotationUtils.findAnnotation(method, Logging.class);
        System.out.println(annos[0]);
    }
}

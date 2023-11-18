package com.bscoder.annotation.amp;

/**
 * @author xujianxing@sensetime.com
 * @Description: TODO
 * @date 2023年01月11日 17:55
 */
public class AbstractMyServiceImpl extends  AbstractMyService{

    @Override
    public  void sayBye(String name) {
        System.out.println("bye，"+name);
    }
}

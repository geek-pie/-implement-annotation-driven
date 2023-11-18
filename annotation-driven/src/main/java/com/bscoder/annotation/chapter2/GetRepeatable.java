package com.bscoder.annotation.chapter2;

import java.lang.annotation.*;


@GetRepeatable.Rule(rule = "week")
@GetRepeatable.Rule(rule = "day")
public class GetRepeatable {

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Rules.class)
    public @interface Rule {
        String rule();
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Rules {
        //容器注解必须包含value方法
        Rule[] value();
    }


    public static void main(String[] args) throws Exception {
        Rule[] ruleArr = GetRepeatable.class.getAnnotationsByType(Rule.class);
        System.out.println("被注解的数量" + ruleArr.length);
        for (Rule rule : ruleArr) {
            System.out.println(rule.rule());
        }
        Rules rules = GetRepeatable.class.getAnnotation(Rules.class);
        System.out.println(rules);
    }
}




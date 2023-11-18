package com.bscoder.annotation.aop.aspectjanno;


import com.bscoder.annotation.common.Logging;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

@Component
@Aspect
public class LoggerInterceptor {

    /**
     * around切面，拦截方法日并打印日志
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("@annotation(com.bscoder.annotation.common.Logging) || @within(com.bscoder.annotation.common.Logging)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        if (!(pjp.getSignature() instanceof MethodSignature)) {
            throw new UnsupportedOperationException("@LoggerAspect annotation only used on the method");
        }
        Logging loggerAspect = getLogging(pjp);
        if (null == loggerAspect) {
            return pjp.proceed();
        }
        Instant start = Instant.now();
        Object result = pjp.proceed();
        Duration duration = Duration.between(start, Instant.now());
        Long timeCost = duration.toMillis();
        System.out.println("timeCost:" + timeCost + "id:" + loggerAspect.id());
        return result;

    }

    /**
     * 获取类或者方法上的LoggerAspect注解
     *
     * @param pjp
     * @return
     */
    private Logging getLogging(ProceedingJoinPoint pjp) {
        Object target = pjp.getTarget();

        // 优先取Class上面的值，如果Class有值，则所有方法都需要被打印日志
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Logging loggerAspect = AnnotationUtils.findAnnotation(methodSignature.getMethod(), Logging.class);
        if (Objects.isNull(loggerAspect)) {
            loggerAspect = AnnotationUtils.findAnnotation(target.getClass(), Logging.class);
        }
        return loggerAspect;
    }

}

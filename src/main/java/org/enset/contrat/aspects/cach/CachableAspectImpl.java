package org.enset.contrat.aspects.cach;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.enset.contrat.aspects.log.Logging;
import org.springframework.stereotype.Component;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Component
@Aspect
public class CachableAspectImpl {
    private long t1,t2;
    private Logger logger=Logger.getLogger(Logging.class.getName());

    public CachableAspectImpl() throws Exception{
        logger.addHandler(new FileHandler("cache.xml"));
        logger.setUseParentHandlers(false);
    }

    @Around(value = "@annotation(CachableAspect)")
    public Object values(ProceedingJoinPoint joinPoint) throws Throwable {
        t1=System.currentTimeMillis();
        logger.info("Avant "+ joinPoint.getSignature());
        Object object=joinPoint.proceed();
        logger.info("Après "+ joinPoint.getSignature());
        t2=System.currentTimeMillis();
        logger.info("Durée : "+ (t2-t1)+"ms");
        return object;
    }
}

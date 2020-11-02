package com.usercorp.utils;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class LoggerProducer {

    @Produces
    public Logger produceLogger(InjectionPoint ip) {
        String className = ip.getMember().getDeclaringClass().getName();
        return Logger.getLogger(className);
    }
}

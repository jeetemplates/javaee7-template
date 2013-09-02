package com.jeetemplates.javaee.logging;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Logger interceptor. Interception binding with annotations {@link Loggable}
 * for binding and {@link Interceptor}.
 * 
 * @author jeetemplates
 */
@Loggable
@Interceptor
public class LoggingInterceptor implements Serializable {

    /**
     * Serial UID.
     */
    private static final long serialVersionUID = 1732537500904150337L;

    /**
     * @see LoggingProducer
     */
    @Inject
    private transient Logger logger;

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        logger.entering(ic.getTarget().getClass().getName(), ic.getMethod().getName());
        logger.info(">>> " + ic.getTarget().getClass().getName() + "-" + ic.getMethod().getName());
        try {
            return ic.proceed();
        } finally {
            logger.exiting(ic.getTarget().getClass().getName(), ic.getMethod().getName());
            logger.info("<<< " + ic.getTarget().getClass().getName() + "-" + ic.getMethod().getName());
        }
    }

}

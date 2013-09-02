package com.jeetemplates.javaee.web.exception;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.jeetemplates.javaee.logging.LoggingProducer;

/**
 * Interceptor for exception in controllers.
 * 
 * @author jeetemplates
 */
@Interceptor
@CatchException
public class ExceptionInterceptor implements Serializable {

    /**
     * Serial UID.
     */
    private static final long serialVersionUID = -8746242473352599312L;

    /**
     * {@link LoggingProducer}
     */
    @Inject
    private Logger logger;

    /**
     * Catch exception
     * 
     * @param ic
     *            : {@link InvocationContext}
     * @return Object
     * @throws Exception
     */
    @AroundInvoke
    public Object catchException(InvocationContext ic) throws Exception {
        try {
            return ic.proceed();
        } catch (Exception e) {
            // Add error in page
            addErrorMessage(e.getMessage());
            // Log
            logger.severe("/!\\ " + ic.getTarget().getClass().getName() + " - " + ic.getMethod().getName() + " - " + e.getMessage());
        }
        return null;
    }

    /**
     * Add error message in JSF.
     * 
     * @param message
     *            : message to display
     */
    protected void addErrorMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }
}

/**
 * 
 */
package com.jeetemplates.javaee.web.exception;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 * Exception factory.
 * 
 * @author jeetemplates
 */
public class DefaultExceptionHandlerFactory extends ExceptionHandlerFactory {

    /**
     * {@link ExceptionHandlerFactory}.
     */
    private ExceptionHandlerFactory parent;

    /**
     * Default constructor.
     */
    public DefaultExceptionHandlerFactory() {

    }

    /**
     * Constructor
     * 
     * @param parent
     *            : parent
     */
    public DefaultExceptionHandlerFactory(ExceptionHandlerFactory parent) {
        this.parent = parent;
    }

    /**
     * @see javax.faces.context.ExceptionHandlerFactory#getExceptionHandler()
     */
    @Override
    public ExceptionHandler getExceptionHandler() {
        ExceptionHandler eh = parent.getExceptionHandler();
        eh = new DefaultExceptionHandler(eh);
        return eh;
    }

}

/**
 * 
 */
package com.jeetemplates.javaee.web.controller;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * Header controller
 * 
 * @author jeetemplates
 */
@Named
@SessionScoped
public class LocaleController implements Serializable {

    /**
     * Serial UID.
     */
    private static final long serialVersionUID = -7522609234232367231L;

    /* ************************************ */
    /* Dependencies */
    /* ************************************ */

    /* ************************************ */
    /* Attributes */
    /* ************************************ */

    /**
     * Locale.
     */
    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    /* ************************************ */
    /* Methods */
    /* ************************************ */

    /**
     * Set language.
     * 
     * @param language
     *            : new language
     */
    public void setLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

    /* ************************************ */
    /* Getters & Setters */
    /* ************************************ */

    /**
     * @return the locale
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * @param locale
     *            the locale to set
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

}

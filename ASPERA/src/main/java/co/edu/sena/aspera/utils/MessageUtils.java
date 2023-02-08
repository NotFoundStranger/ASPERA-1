/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.aspera.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Fecha: 11/08/2022
 * @author Aprendiz
 * Objetivo: clase de utilería para mensajes en pantalla
 */
public class MessageUtils {
    
    public static void addErrorMessage(String message)
    {
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", message));
    }
    
    public static void addWarningMessage(String message)
    {
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia", message));
    }
    
    public static void addInfoMessage(String message)
    {
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", message));
    }
}
